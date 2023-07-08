package com.landMark.landMark.Controller;

import com.landMark.landMark.Entity.Image;
import com.landMark.landMark.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

  @Autowired
  public ImageService imageService;

    @PostMapping("/upload/{countryId}")
    public ResponseEntity<Image> uploadSliku(@RequestParam("file") MultipartFile file,
                                             @RequestParam("name") String name,
                                             @RequestParam("description") String description,
                                             @RequestParam("latitude") String latitude,
                                             @RequestParam("longitude") String longitude,
                                             @RequestParam("importance") String importance,
                                             @PathVariable("countryId") Long countryId) throws IOException {

        Image savedImage = imageService.uploadImage(file, name, description, latitude, longitude,importance ,countryId);
        return ResponseEntity.ok(savedImage);
    }


    @GetMapping("/searchByImportance")
    public List<Image> searchImagesByImportance(@RequestParam String importance) {
        return imageService.getAllImagesByImportance(importance);
    }

    @GetMapping("/allImagesImage")
    public ResponseEntity<List<String>> getAllImagesImage() {
        List<Image> images = imageService.getAllImagesImages();
        List<String> base64Images = new ArrayList<>();
        for (Image image : images) {
            String base64Image = Base64.getEncoder().encodeToString(image.getContent());
            base64Images.add(base64Image);
        }
        if (!base64Images.isEmpty()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(base64Images);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allImages")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        List<Image> imageInfos = new ArrayList<>();
        for (Image image : images) {
            String base64Image = Base64.getEncoder().encodeToString(image.getContent());
            Image imageInfo = new Image();
            imageInfo.setId(image.getId());
            imageInfo.setName(image.getName());
            imageInfo.setDescription(image.getDescription());
            imageInfo.setLatitude(image.getLatitude());
            imageInfo.setLongitude(image.getLongitude());
            imageInfo.setContent(base64Image.getBytes());
            imageInfos.add(imageInfo);
        }
        if (!imageInfos.isEmpty()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(imageInfos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
