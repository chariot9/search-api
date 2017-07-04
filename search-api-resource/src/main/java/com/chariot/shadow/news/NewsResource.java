package com.chariot.shadow.news;

import com.chariot.shadow.Keyword;
import com.chariot.shadow.cache.CacheName;
import com.chariot.shadow.common.Limiter;
import com.chariot.shadow.common.SortType;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trung Vu on 2017/07/02.
 */
@RestController
@RequestMapping(value = "/search-api/news")
public class NewsResource {

    @Autowired
    private NewsApplication newsApplication;
    @Autowired
    private NewsMapper mapper;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Cacheable(CacheName.NEWS)
    public NewsCollectionJson search(@RequestParam(value = "keyword") Keyword keyword,
                                     @RequestParam(value = "language", required = false, defaultValue = "ENGLISH") Language language,
                                     @RequestParam(value = "country", required = false, defaultValue = "JAPAN") Country country,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") Limiter limiter,
                                     @RequestParam(value = "sort", required = false, defaultValue = "DESCENDING") SortType sortType) {
        return mapper.map(newsApplication.search(keyword, language, country, limiter, sortType));
    }
}
