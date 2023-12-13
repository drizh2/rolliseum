import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/entity/user';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  isLoggedIn = false;
  isDataLoaded = false;
  user!: User;

  constructor(private tokenService: TokenStorageService,
    private userService: UserService,
    private router: Router) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenService.getToken();

    if (this.isLoggedIn) {
      this.userService.getCurrentUser()
        .subscribe(data => {
          this.user = data;
          this.isDataLoaded = true;
        });
    }
  }

  logout(): void {
    this.tokenService.logout();
    this.router.navigate(['/login']);
  }
}
