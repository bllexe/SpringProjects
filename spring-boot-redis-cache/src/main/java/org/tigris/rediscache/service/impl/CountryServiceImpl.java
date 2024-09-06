package org.tigris.rediscache.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.tigris.rediscache.entity.Country;
import org.tigris.rediscache.repos.CountryRepository;
import org.tigris.rediscache.service.CountryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.tigris.rediscache.utils.CountryInitializer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

   private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Cacheable(cacheNames = "countryNames")
    @Override
    public List<String> getAllCountryNames() {
        System.out.println("connect redis cache did not use");
        return  countryRepository.findAllCountryNames();
    }

    @Override
    public List<Country> insertCountries() {
        return countryRepository.saveAll(CountryInitializer.initCountries());
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "countryNames", allEntries = true, condition = "#country.code != null")
            }
    )
    @Override
    public Country insertCountry(Country country) {
        return countryRepository.save(country);
    }
}
