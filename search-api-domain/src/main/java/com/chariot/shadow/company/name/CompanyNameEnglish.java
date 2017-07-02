package com.chariot.shadow.company.name;

import lombok.Value;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Value
public class CompanyNameEnglish implements Comparable<CompanyNameEnglish> {

    private String name;

    @Override
    public int compareTo(CompanyNameEnglish o) {
        return name.compareTo(o.getName());
    }
}
