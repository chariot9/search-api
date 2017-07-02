package com.chariot.shadow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trung Vu on 2017/06/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentJson {

    protected float score;
    protected ContentsJson contents;
}
