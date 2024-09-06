package org.tigris.rediscache.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tigris.rediscache.entity.Country;
import org.tigris.rediscache.modal.CountryDto;
import org.tigris.rediscache.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private  final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(){

        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDto> insertCountry(@RequestBody CountryDto countryDto){
        Country country = countryService.insertCountry(countryDto.fromCountryDto(countryDto));
        return new ResponseEntity<>(countryDto.toCountryDto(country), HttpStatus.CREATED);
    }

    @GetMapping("/names")
    public List<String> getAllCountryNames(){
        return countryService.getAllCountryNames();
    }

    @PostMapping("/insertAll")
    public List<Country> insertCountries(){
        return countryService.insertCountries();
    }

}
