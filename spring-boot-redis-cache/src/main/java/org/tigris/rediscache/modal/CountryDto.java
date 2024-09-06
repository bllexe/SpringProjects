package org.tigris.rediscache.modal;

import lombok.Builder;
import org.tigris.rediscache.entity.Country;

@Builder
public record CountryDto(Long id, String code, String name,
                         String nativeName, int phone,
                         String capital, String continent,
                         String currency, String language, String flag) {


    public CountryDto toCountryDto(Country country){

        return CountryDto.builder()
                .id(country.getId())
                .code(country.getCode())
                .name(country.getName())
                .nativeName(country.getNativeName())
                .phone(country.getPhone())
                .capital(country.getCapital())
                .continent(country.getContinent())
                .currency(country.getCurrency())
                .language(country.getLanguage())
                .flag(country.getFlag())
                .build();

    }

    public Country fromCountryDto(CountryDto countryDto){
        return Country.builder()
                .code(countryDto.code)
                .name(countryDto.name)
                .nativeName(countryDto.nativeName)
                .phone(countryDto.phone)
                .capital(countryDto.capital)
                .continent(countryDto.continent)
                .currency(countryDto.currency)
                .language(countryDto.language)
                .flag(countryDto.flag)
                .build();
    }
}
