package com.chariot.shadow.news;

import com.chariot.shadow.Keyword;
import com.chariot.shadow.common.Contents;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import com.chariot.shadow.news.factory.NewsFactory;
import com.chariot.shadow.supplier.Supplier;
import com.chariot.shadow.supplier.SupplierCode;
import com.chariot.shadow.supplier.SupplierID;
import com.chariot.shadow.supplier.SupplierName;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Trung Vu on 2017/07/01.
 */
@Component
public class NewsRepository {

    @Autowired
    private NewsInfrastructure newsInfrastructure;

    public Newses search(Keyword keyword, Language language, Country country) {
        Optional<SearchHits> searchHits = newsInfrastructure.search(keyword.getKeyword(), language.getCode(), country.getIsoCode());

        if (!searchHits.isPresent()) {
            return Newses.EMPTY;
        }

        return new Newses(StreamSupport.stream(searchHits.get().spliterator(), false).map(this::map).collect(Collectors.toList()));
    }

    private News map(SearchHit searchHit) {
        Map<String, Object> objects = searchHit.getSource();

        float score = searchHit.getScore();
        NewsID newsID = new NewsID((String) objects.get("newsId"));
        NewsSupplierType supplierType = NewsSupplierType.get(Integer.valueOf((String) objects.get("supplierId")));
        Supplier supplier = new Supplier(
                new SupplierID(supplierType.getId()),
                new SupplierCode(supplierType.getCode()),
                new SupplierName(supplierType.getName()));
        NewsTitle title = new NewsTitle((String) objects.get("title"));
        NewsContent content = new NewsContent((String) objects.get("content"));
        NewsLink link = new NewsLink((String) objects.get("link"));
        NewsPublishedDate date = new NewsPublishedDate((String) objects.get("publishDate"));
        Language language = Language.get((String) objects.get("language"));
        Country country = Country.get((String) objects.get("country"));

        return NewsFactory.create(score, Contents.NEWS, newsID, supplier, title, content, link, date, language, country);
    }
}
