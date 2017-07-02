package com.chariot.shadow.news;

import com.chariot.shadow.Data;
import com.chariot.shadow.common.Contents;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import com.chariot.shadow.supplier.Supplier;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
public class News extends Data implements Comparable<News> {

    private NewsID id;
    private Supplier supplier;
    private NewsTitle title;
    private NewsContent content;
    private NewsLink link;
    private NewsPublishedDate publishedDate;
    private Language language;
    private Country country;

    public News(float score, Contents contents, NewsID id, Supplier supplier, NewsTitle title, NewsContent content, NewsLink link, NewsPublishedDate publishedDate, Language language, Country country) {
        super(score, contents);
        this.id = id;
        this.supplier = supplier;
        this.title = title;
        this.content = content;
        this.link = link;
        this.publishedDate = publishedDate;
        this.language = language;
        this.country = country;
    }

    @Override
    public int compareTo(News o) {
        return Float.compare(score, o.getScore());
    }
}
