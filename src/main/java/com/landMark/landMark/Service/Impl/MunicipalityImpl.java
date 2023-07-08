package com.landMark.landMark.Service.Impl;

import com.landMark.landMark.Entity.Country;
import com.landMark.landMark.Entity.Municipality;
import com.landMark.landMark.Repository.CountryRepository;
import com.landMark.landMark.Repository.MunicipalityRepository;
import com.landMark.landMark.Service.CountryService;
import com.landMark.landMark.Service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityImpl implements MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    CountryService countryService;


    @Override
    public Municipality addCountry(Municipality municipality, Long countryId){
        Country country = countryService.getCountryId(countryId);
        municipality.setCountry(country);
      return  municipalityRepository.save(municipality );
    }

    @Override
    public Municipality getId(Long id) {
        return municipalityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Municipality> getAllMunicipality() {
        return municipalityRepository.findAll();
    }
}
