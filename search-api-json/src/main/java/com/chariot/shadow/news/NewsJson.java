package com.chariot.shadow.news;

import com.chariot.shadow.ContentJson;
import com.chariot.shadow.ContentsJson;
import com.chariot.shadow.country.CountryJson;
import com.chariot.shadow.language.LanguageJson;
import com.chariot.shadow.supplier.SupplierJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class NewsJson extends ContentJson {

    private String newsId;
    private SupplierJson supplier;
    private NewsTitleJson title;
    private NewsContentJson content;
    private NewsLinkJson link;
    private NewsPublishedDateJson publishedDate;
    private LanguageJson language;
    private CountryJson country;

    public NewsJson(float score, ContentsJson contents, String newsId, SupplierJson supplier, NewsTitleJson title, NewsContentJson content, NewsLinkJson link, NewsPublishedDateJson publishedDate, LanguageJson language, CountryJson country) {
        super(score, contents);
        this.newsId = newsId;
        this.supplier = supplier;
        this.title = title;
        this.content = content;
        this.link = link;
        this.publishedDate = publishedDate;
        this.language = language;
        this.country = country;
    }
}
