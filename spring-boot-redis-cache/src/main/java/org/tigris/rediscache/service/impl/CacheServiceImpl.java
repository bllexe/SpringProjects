package org.tigris.rediscache.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tigris.rediscache.service.CacheService;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class CacheServiceImpl implements CacheService {

    private final RedisCacheManager cacheManager;

    @Override
    public void evictCacheValues(String cacheName) {

        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        log.info("Evicted cache: {}", cacheName);
    }
}
