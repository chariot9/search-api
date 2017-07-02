package com.chariot.shadow.news;

import com.chariot.shadow.Keyword;
import com.chariot.shadow.common.Limiter;
import com.chariot.shadow.common.SortType;
import com.chariot.shadow.country.Country;
import com.chariot.shadow.language.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Trung Vu on 2017/07/02.
 */
@Component
public class NewsApplication {

    @Autowired
    private NewsRepository newsRepository;

    public Newses search(Keyword keyword, Language language, Country country, Limiter limiter, SortType sortType) {
        return newsRepository.search(keyword, language, country).sort(sortType).limit(limiter);
    }
}
