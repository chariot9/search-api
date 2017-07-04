package com.chariot.shadow.cache;

import lombok.Value;

import javax.cache.configuration.Factory;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ExpiryPolicy;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by Trung Vu on 2017/07/04.
 */
@Value
public class CacheExpiryFactory implements Factory<ExpiryPolicy> {

    private Optional<Integer> duration;

    @Override
    public ExpiryPolicy create() {
        return new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, duration.orElse(60)));
    }
}
