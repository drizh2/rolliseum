import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {User} from 'src/app/entity/user';
import {ImageUploadService} from 'src/app/service/image-upload.service';
import {NotificationService} from 'src/app/service/notification.service';
import {TokenStorageService} from 'src/app/service/token-storage.service';
import {UserService} from 'src/app/service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  isDataLoaded = false;
  user!: User;
  selectedImage!: File;
  userImage!: File;
  previewImageUrl: any;

  constructor(private tokenService: TokenStorageService,
              private dialog: MatDialog,
              private notificationService: NotificationService,
              private imageService: ImageUploadService,
              private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getCurrentUser()
      .subscribe(data => {
        this.user = data;
        this.isDataLoaded = true;
      });

      this.imageService.getProfileImage()
        .subscribe(data => {
          this.userImage = data.imageBytes;
        })
  }

  onFileSelected(event: any): void {
    this.selectedImage = event.target.files[0];

    const reader = new FileReader();
    reader.readAsDataURL(this.selectedImage);
    reader.onload = () => {
      this.previewImageUrl = reader.result;
    };
  }

  formatImage(img: any): any {
    if(img == null) {
      return null;
    }

    return 'data:image/jpeg;base64, ' + img;
  }

  onUpload(): void {
    if(this.selectedImage != null) {
      this.imageService.uploadImageToUser(this.selectedImage)
        .subscribe(() => {
            this.notificationService.showSnackBar('Profile image has been uploaded succesfully!');
        });
    }
  }
}
