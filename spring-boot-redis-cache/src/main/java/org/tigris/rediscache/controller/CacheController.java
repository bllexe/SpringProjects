package org.tigris.rediscache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tigris.rediscache.service.CacheService;

@Profile("!prod")
@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @DeleteMapping("/names/evict")
    public boolean evictCountryNamesCache() {
        cacheService.evictCacheValues("countryNames");
        return true;
    }
}
