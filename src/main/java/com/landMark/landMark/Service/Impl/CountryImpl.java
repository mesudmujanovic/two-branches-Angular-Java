package com.landMark.landMark.Service.Impl;

import com.landMark.landMark.Entity.Country;
import com.landMark.landMark.Repository.CountryRepository;
import com.landMark.landMark.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;


    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryId(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
