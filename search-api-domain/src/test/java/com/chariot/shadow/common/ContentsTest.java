package com.chariot.shadow.common;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class ContentsTest {

    @Test
    public void getContentTypeById() throws Exception {
        assertThat(Contents.get(1), is(Contents.NEWS));
    }

    @Test
    public void getContentTypeByName() throws Exception {
        assertThat(Contents.get("company"), is(Contents.COMPANY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidId() throws Exception {
        Contents.get(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidName() throws Exception {
        Contents.get("invalid name");
    }
}