package com.chariot.shadow.common;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/28.
 */
public class LimiterTest {

    @Test
    public void createNewsLimiterByIntVariable() throws Exception {
        assertThat(Limiter.of("5").getLimit(), Is.is(5));
    }
}