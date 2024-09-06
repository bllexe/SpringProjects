package org.tigris.rediscache.service;

import org.springframework.stereotype.Service;
import org.tigris.rediscache.entity.Country;

import java.util.List;

@Service
public interface CountryService {

    List<Country> getAllCountries();

    List<String> getAllCountryNames();

    List<Country> insertCountries();

    Country insertCountry(Country country);;

}
