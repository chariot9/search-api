package com.chariot.shadow.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by Trung Vu on 2017/06/28.
 */
@AllArgsConstructor
@Getter
public enum SortType {

    ASCENDING("asc"),
    DESCENDING("desc");

    private String text;

    public static SortType get(String str) {
        return Arrays.stream(values()).filter(e -> e.text.equals(str)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("args is [%s]", str)));
    }
}
