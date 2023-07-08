package com.landMark.landMark.Service;

import com.landMark.landMark.Entity.Municipality;

import java.util.List;

public interface MunicipalityService {

    Municipality addCountry(Municipality country, Long countryId);

    Municipality getId(Long id );

    List<Municipality> getAllMunicipality();
}
