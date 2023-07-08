package com.landMark.landMark.Service;

import com.landMark.landMark.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    Image uploadImage(MultipartFile file, String name, String description, String latitude, String longitude,String importance, Long countryId) throws IOException;
    List<Image> getAllImages();

    List<Image> getAllImagesImages();

    List<Image> getAllImagesByImportance(String importance);

}
