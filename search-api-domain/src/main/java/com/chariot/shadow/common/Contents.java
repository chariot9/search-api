package com.chariot.shadow.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@AllArgsConstructor
@Getter
public enum Contents {

    NEWS(1, "news"),
    COMPANY(2, "company");

    private int id;
    private String name;

    public static Contents get(int id) {
        return Stream.of(values()).filter(value -> value.id == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static Contents get(String name) {
        return Stream.of(values()).filter(value -> value.name.equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
