package com.chariot.shadow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * Created by Trung Vu on 2017/07/02.
 */
@AllArgsConstructor
@Getter
public enum ContentsJson {

    NEWS(1, "news"),
    COMPANY(2, "company");

    private int id;
    private String name;

    public static ContentsJson get(int id) {
        return Stream.of(values()).filter(value -> value.id == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static ContentsJson get(String name) {
        return Stream.of(values()).filter(value -> value.name.equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
