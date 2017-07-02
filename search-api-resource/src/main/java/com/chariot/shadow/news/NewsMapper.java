package com.chariot.shadow.news;

import com.chariot.shadow.ContentsJson;
import com.chariot.shadow.Mappable;
import com.chariot.shadow.country.CountryJson;
import com.chariot.shadow.language.LanguageJson;
import com.chariot.shadow.supplier.SupplierCodeJson;
import com.chariot.shadow.supplier.SupplierIDJson;
import com.chariot.shadow.supplier.SupplierJson;
import com.chariot.shadow.supplier.SupplierNameJson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Trung Vu on 2017/07/02.
 */
@Component
public class NewsMapper implements Mappable<NewsCollectionJson, Newses> {

    @Override
    public NewsCollectionJson map(Newses source) {
        List<NewsJson> newsJsons = source.getNewses().stream().map(news -> {
            String newsId = news.getId().getId();
            SupplierJson supplier = new SupplierJson(
                    new SupplierIDJson(news.getSupplier().getId().getId()),
                    new SupplierCodeJson(news.getSupplier().getCode().getCode()),
                    new SupplierNameJson(news.getSupplier().getName().getName()));
            NewsTitleJson title = new NewsTitleJson(news.getTitle().getTitle());
            NewsContentJson content = new NewsContentJson(news.getContent().getContent());
            NewsLinkJson link = new NewsLinkJson(news.getLink().getLink());
            NewsPublishedDateJson date = new NewsPublishedDateJson(news.getPublishedDate().getPublishedDate());
            LanguageJson language = new LanguageJson(news.getLanguage().getCode());
            CountryJson country = new CountryJson(news.getCountry().getIsoCode());

            return new NewsJson(news.getScore(), ContentsJson.NEWS, newsId, supplier, title, content, link, date, language, country);
        }).collect(Collectors.toList());

        return new NewsCollectionJson(newsJsons);
    }
}
