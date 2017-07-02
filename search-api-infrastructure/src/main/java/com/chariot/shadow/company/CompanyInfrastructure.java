package com.chariot.shadow.company;

import com.chariot.shadow.ElasticsearchInfrastructure;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * Created by Trung Vu on 2017/06/28.
 */
public class CompanyInfrastructure extends ElasticsearchInfrastructure {

    @Override
    public void init() {
        super.init();
        index = "company";
        type = "import";
    }

    @Override
    public Optional<QueryBuilder> build() {
        return null;
    }

    @Override
    public SearchRequestBuilder createSearchBuilder() {
        return client.
                prepareSearch().
                setIndices(index).
                setTypes(type).
                setSearchType(SearchType.QUERY_THEN_FETCH).
                setFetchSource(false).
                setTrackScores(true);
    }
}
