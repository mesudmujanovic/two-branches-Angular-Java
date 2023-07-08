package com.landMark.landMark.Repository;

import com.landMark.landMark.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
