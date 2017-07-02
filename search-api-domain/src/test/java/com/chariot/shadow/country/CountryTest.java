package com.chariot.shadow.country;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class CountryTest {

    @Test
    public void getCountryByCountryCode() throws Exception {
        assertThat(Country.get(81), Is.is(Country.JAPAN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidCountryCode() throws Exception {
        Country.get(-100);
    }

    @Test
    public void getCountryByIsoCode() throws Exception {
        assertThat(Country.get("JPN"), Is.is(Country.JAPAN));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidIsoCode() throws Exception {
        Country.get("Invalid");
    }
}