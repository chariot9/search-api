package com.chariot.shadow;

import com.chariot.shadow.cache.CacheDuration;
import com.chariot.shadow.cache.CacheExpiryFactory;
import com.chariot.shadow.cache.CacheName;
import com.chariot.shadow.news.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import java.util.Optional;

/**
 * Created by Trung Vu on 2017/07/02.
 */
@SpringBootApplication
@EnableCaching
public class SearchApiApplication {

    @Autowired
    private CacheDuration duration;

    public static void main(String[] args) {
        SpringApplication.run(SearchApiApplication.class, args);
    }

    @Bean
    public JCacheCacheManager cacheManager() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        cacheManager.createCache(CacheName.NEWS, this.<Keyword, News>create());

        return new JCacheCacheManager(cacheManager);
    }

    private <X, Y> MutableConfiguration<X, Y> create() {
        return new MutableConfiguration<X, Y>().setExpiryPolicyFactory(
                new CacheExpiryFactory(
                        Optional.ofNullable(duration.getDuration()))).setStoreByValue(false);
    }
}
