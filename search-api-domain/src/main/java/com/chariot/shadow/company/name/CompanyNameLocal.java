package com.chariot.shadow.company.name;

import lombok.Value;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Value
public class CompanyNameLocal implements Comparable<CompanyNameLocal> {

    private String name;

    @Override
    public int compareTo(CompanyNameLocal o) {
        return name.compareTo(o.getName());
    }
}
