package org.tigris.rediscache.service;

import org.springframework.stereotype.Service;

@Service
public interface CacheService {

    void evictCacheValues(String cacheName);
}
