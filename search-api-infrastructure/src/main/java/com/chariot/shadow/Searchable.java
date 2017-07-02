package com.chariot.shadow;

import java.util.Optional;

/**
 * Created by Trung Vu on 2017/06/27.
 */
public interface Searchable<T> {

    void init();

    Optional<T> search();

    void close();
}
