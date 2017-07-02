package com.chariot.shadow.language;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/29.
 */
public class LanguageTest {

    @Test
    public void createLanguageByCode() throws Exception {
        assertThat(Language.get("JPN"), Is.is(Language.JAPANESE));
    }
}