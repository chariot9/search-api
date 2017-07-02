package com.chariot.shadow.common;

import lombok.Value;

/**
 * Created by Trung Vu on 2017/06/28.
 */
@Value
public class Limiter {

    private int limit;

    public static Limiter of(String limit) {
        return new Limiter(Integer.valueOf(limit));
    }
}
