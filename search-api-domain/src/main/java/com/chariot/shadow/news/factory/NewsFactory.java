package com.chariot.shadow.news.factory;

import com.chariot.shadow.common.Contents;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import com.chariot.shadow.news.*;
import com.chariot.shadow.supplier.Supplier;

/**
 * Created by Trung Vu on 2017/06/26.
 */
public class NewsFactory {

    public static News create(float score, Contents contents, NewsID id, Supplier supplier, NewsTitle title, NewsContent content, NewsLink link, NewsPublishedDate publicationDate, Language language, Country country) {
        return new News(score, contents, id, supplier, title, content, link, publicationDate, language, country);
    }
}
