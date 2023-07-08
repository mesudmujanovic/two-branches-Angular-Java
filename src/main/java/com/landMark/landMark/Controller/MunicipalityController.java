package com.landMark.landMark.Controller;

import com.landMark.landMark.Entity.Municipality;
import com.landMark.landMark.Service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipality")
@CrossOrigin("*")
public class MunicipalityController {

    @Autowired
    MunicipalityService municipalityService;

    @PostMapping("/municipality/{countryId}")
    private ResponseEntity<Municipality> saveCountry(@RequestBody Municipality country,
                                                     @PathVariable Long countryId){
        Municipality savedCountry = municipalityService.addCountry(country, countryId);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

   @GetMapping("/getAllMunicipality")
    private ResponseEntity<List<Municipality>> findAllMunicipality(){
        List<Municipality> municipalityList = municipalityService.getAllMunicipality();
        return ResponseEntity.ok(municipalityList);
   }

}
