package com.chariot.shadow.news;

import com.chariot.shadow.common.Limiter;
import com.chariot.shadow.common.SortType;
import com.chariot.shadow.supplier.Supplier;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.reverseOrder;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

/**
 * Created by Trung Vu on 2017/06/27.
 */
@Value
public class Newses {

    private List<News> newses;
    public static final Newses EMPTY = new Newses(emptyList());

    public Newses limit(Limiter limiter) {
        return new Newses(newses.stream().limit(limiter.getLimit()).collect(toList()));
    }

    public Newses sort(SortType sortType) {
        Map<Supplier, List<News>> newsMap = split();
        List<News> newsList = new ArrayList<>();

        if (sortType == SortType.DESCENDING) {
            newsMap.keySet().forEach(supplier -> newsList.addAll(ofNullable(newsMap.get(supplier)).map(e -> e.stream().sorted(reverseOrder()).collect(toList())).orElse(emptyList())));
            return new Newses(newsList);
        }

        newsMap.keySet().forEach(supplier -> newsList.addAll(ofNullable(newsMap.get(supplier)).map(e -> e.stream().sorted().collect(toList())).orElse(emptyList())));
        return new Newses(newsList);
    }

    private Map<Supplier, List<News>> split() {
        return newses.stream().collect(Collectors.groupingBy(News::getSupplier));
    }
}
