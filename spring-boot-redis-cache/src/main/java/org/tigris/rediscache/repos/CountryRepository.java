package org.tigris.rediscache.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tigris.rediscache.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c.name FROM Country c")
    List<String> findAllCountryNames();
}
