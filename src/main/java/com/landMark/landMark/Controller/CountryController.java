package com.landMark.landMark.Controller;


import com.landMark.landMark.Entity.Country;
import com.landMark.landMark.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/country")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country){
        Country country1 = countryService.saveCountry(country);
        return ResponseEntity.ok(country1);
    }
}
