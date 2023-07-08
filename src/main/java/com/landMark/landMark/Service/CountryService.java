package com.landMark.landMark.Service;

import com.landMark.landMark.Entity.Country;

public interface CountryService {

    Country saveCountry (Country country);

    Country getCountryId( Long id);
}
