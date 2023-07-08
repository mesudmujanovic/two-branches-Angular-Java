package com.landMark.landMark.Service.Impl;

import com.landMark.landMark.Entity.Municipality;
import com.landMark.landMark.Entity.Image;
import com.landMark.landMark.Enum.Importance;
import com.landMark.landMark.Repository.ImageRepository;
import com.landMark.landMark.Service.MunicipalityService;
import com.landMark.landMark.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageImpl  implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    MunicipalityService countryService;




//    @Override
//    public Image uploadImage(MultipartFile file,
//                             String name,
//                             String description,
//                             String latitude,
//                             String longitude,
//                             Long countryId) throws IOException {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        Image image = new Image();
//        image.setName(name);
//        image.setDescription(description);
//        image.setLongitude(longitude);
//        image.setLatitude(latitude);
//        image.setContent(file.getBytes());
//        Municipality country = countryService.getId(countryId);
//        image.setMunicipality(country);
//        return imageRepository.save(image);
//    }


    @Override
    public Image uploadImage(MultipartFile file, String name, String description, String latitude, String longitude,String importance, Long countryId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Image image = new Image();
        image.setName(name);
        image.setDescription(description);
        image.setLongitude(longitude);
        image.setLatitude(latitude);
        image.setContent(file.getBytes());

        // Mapiranje vrijednosti importance na enum Importance
        Importance importanceValue;
        if (importance.equalsIgnoreCase("VAZNO")) {
            importanceValue = Importance.VAZNO;
        } else if (importance.equalsIgnoreCase("VEOMA_VAZNO")) {
            importanceValue = Importance.VEOMA_VAZNO;
        } else if (importance.equalsIgnoreCase("NEZAOBILAZNO")) {
            importanceValue = Importance.NEZAOBILAZNO;
        } else {
            throw new IllegalArgumentException("Invalid importance value: " + importance);
        }
        image.setImportance(importanceValue);

        Municipality country = countryService.getId(countryId);
        image.setMunicipality(country);
        return imageRepository.save(image);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getAllImagesImages() {
        return  imageRepository.findAll();
    }

    @Override
    public List<Image> getAllImagesByImportance(String importance) {
        Importance enumImportance = Importance.valueOf(importance);
        return imageRepository.findByImportance(enumImportance);
    }


}
