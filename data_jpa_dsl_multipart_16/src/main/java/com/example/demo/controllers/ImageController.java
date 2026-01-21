package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.CustomerImage;
import com.example.demo.services.ImageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/images")
@AllArgsConstructor

public class ImageController {

    private final ImageService imageService;

    @PostMapping("/save")
    public ResponseEntity<CustomerImage> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        CustomerImage savedImage = imageService.save(
            file.getContentType(), 
            file.getOriginalFilename(), 
            file.getBytes()
        );
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        CustomerImage customerImage = this.imageService.findById(id);
        
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(customerImage.getImageRef()); 
            }

}


