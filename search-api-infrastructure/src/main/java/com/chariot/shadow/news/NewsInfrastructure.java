package com.chariot.shadow.news;

import com.chariot.shadow.ElasticsearchInfrastructure;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Trung Vu on 2017/06/28.
 */
@Component
public class NewsInfrastructure extends ElasticsearchInfrastructure {

    private static final String TITLE = "title";
    private static final String CONTENT = "content";

    private String language;
    private String country;
    private String keyword;

    @Override
    public void init() {
        super.init();
        index = "news";
        type = "import";
    }

    @Override
    public Optional<QueryBuilder> build() {
        QueryBuilder queryBuilder = QueryBuilders.
                disMaxQuery().
                add(QueryBuilders.termQuery(TITLE, keyword)).
                add(QueryBuilders.termQuery(CONTENT, keyword));
        return Optional.of(queryBuilder);
    }

    @Override
    public SearchRequestBuilder createSearchBuilder() {
        return client.
                prepareSearch().
                setIndices(index).
                setTypes(type).
                setSearchType(SearchType.QUERY_THEN_FETCH);
    }

    public Optional<SearchHits> search(String keyword, String language, String country) {
        this.keyword = keyword;
        this.language = language;
        this.country = country;
        return search();
    }
}
