package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.entity.ImageModel;
import com.drizh2.rolliseum.payload.response.MessageResponse;
import com.drizh2.rolliseum.service.ImageModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/image")
public class ImageUploadController {

    private final ImageModelService imageModelService;

    @Autowired
    public ImageUploadController(ImageModelService imageModelService) {
        this.imageModelService = imageModelService;
    }

    @PostMapping("/user/upload")
    public ResponseEntity<MessageResponse> uploadImageToUser(@RequestParam("file")MultipartFile image,
                                                             Principal principal) throws IOException {
        imageModelService.uploadImageToUser(image, principal);

        return new ResponseEntity<>(new MessageResponse("Image has been uploaded successfully!"), HttpStatus.OK);
    }

    @PostMapping("/character/{characterId}/upload")
    public ResponseEntity<MessageResponse> uploadImageToCharacter(@RequestParam("file") MultipartFile image,
                                                                  @PathVariable("characterId") String characterId,
                                                                  Principal principal) throws IOException {
        imageModelService.uploadImageToCharacter(image, principal, Long.parseLong(characterId));

        return new ResponseEntity<>(new MessageResponse("Image has been uploaded successfully!"), HttpStatus.OK);
    }

    @GetMapping("/userImage")
    public ResponseEntity<ImageModel> getImageForUser(Principal principal) {
        ImageModel imageModel = imageModelService.getImageToUser(principal);

        return new ResponseEntity<>(imageModel, HttpStatus.OK);
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<ImageModel> getImageForCharacter(@PathVariable("characterId") String characterId) {
        ImageModel imageModel = imageModelService.getImageToCharacter(Long.parseLong(characterId));

        return new ResponseEntity<>(imageModel, HttpStatus.OK);
    }
}
