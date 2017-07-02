package com.chariot.shadow;

/**
 * Created by Trung Vu on 2017/07/02.
 */
public interface Mappable<T, K> {

    T map(K source);
}
