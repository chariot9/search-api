package com.chariot.shadow.company;

import com.chariot.shadow.common.Limiter;
import com.chariot.shadow.common.SortType;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Comparator.reverseOrder;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

/**
 * Created by Trung Vu on 2017/06/28.
 */
@Value
public class Companies {

    private List<Company> companies;
    private static final Companies EMPTY = new Companies(emptyList());

    public Companies limit(Limiter limiter) {
        return new Companies(companies.stream().limit(limiter.getLimit()).collect(toList()));
    }

    private Map<CompanyCountry, List<Company>> split() {
        return companies.stream().collect(Collectors.groupingBy(Company::getCountry, toList()));
    }

    public Companies sort(SortType sortType) {
        Map<CompanyCountry, List<Company>> companyMap = split();
        List<Company> companyList = new LinkedList<>();

        if (sortType == SortType.DESCENDING) {
            companyMap.keySet().forEach(companyCountry -> companyList.addAll(ofNullable(companyMap.get(companyCountry)).map(e -> e.stream().sorted(reverseOrder()).collect(toList())).orElse(emptyList())));
            return new Companies(companyList);
        }

        companyMap.keySet().forEach(companyCountry -> companyList.addAll(ofNullable(companyMap.get(companyCountry)).map(e -> e.stream().sorted().collect(toList())).orElse(emptyList())));
        return new Companies(companyList);
    }
}
