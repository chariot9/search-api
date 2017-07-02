package com.chariot.shadow.news;

import lombok.Value;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Value
public class NewsPublishedDate implements Comparable<NewsPublishedDate> {

    private String publishedDate;

    @Override
    public int compareTo(NewsPublishedDate o) {
        return publishedDate.compareTo(o.getPublishedDate());
    }
}
