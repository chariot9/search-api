package com.chariot.shadow;

import com.chariot.shadow.config.Elasticsearch;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;

import java.util.Optional;

/**
 * Created by Trung Vu on 2017/06/28.
 */
public abstract class ElasticsearchInfrastructure implements Searchable<SearchHits> {

    protected Client client;
    protected String index;
    protected String type;

    @Override
    public void init() {
        client = Elasticsearch.getInstance();
    }

    @Override
    public Optional<SearchHits> search() {
        init();
        return build().map(builder -> createSearchBuilder().setQuery(builder).get().getHits());
    }

    @Override
    public void close() {
        Elasticsearch.dispose();
    }

    public abstract Optional<QueryBuilder> build();

    public abstract SearchRequestBuilder createSearchBuilder();
}
