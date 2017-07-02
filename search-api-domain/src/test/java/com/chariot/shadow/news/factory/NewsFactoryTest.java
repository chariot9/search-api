package com.chariot.shadow.news.factory;

import com.chariot.shadow.common.Contents;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import com.chariot.shadow.news.*;
import com.chariot.shadow.supplier.Supplier;
import mockit.Mocked;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class NewsFactoryTest {

    @Test
    public void createNewsByEachComponents(@Mocked NewsID newsID, @Mocked Supplier supplier,
                                           @Mocked NewsTitle newsTitle, @Mocked NewsContent newsContent,
                                           @Mocked NewsLink newsLink, @Mocked NewsPublishedDate newsPublishedDate,
                                           @Mocked Language language, @Mocked Country country) throws Exception {
        News news = NewsFactory.create(1f, Contents.NEWS, newsID, supplier, newsTitle, newsContent, newsLink, newsPublishedDate, language, country);
        assertThat(news.getId(), Is.is(newsID));
        assertThat(news.getSupplier(), Is.is(supplier));
        assertThat(news.getTitle(), Is.is(newsTitle));
        assertThat(news.getContent(), Is.is(newsContent));
        assertThat(news.getLink(), Is.is(newsLink));
        assertThat(news.getPublishedDate(), Is.is(newsPublishedDate));
        assertThat(news.getLanguage(), Is.is(language));
        assertThat(news.getCountry(), Is.is(country));
    }
}