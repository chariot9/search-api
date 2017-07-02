package com.chariot.shadow;

import com.chariot.shadow.common.Contents;
import lombok.Getter;

/**
 * Created by Trung Vu on 2017/06/28.
 */
@Getter
public class Data {

    protected float score;
    protected Contents contents;

    public Data(float score, Contents contents) {
        this.score = score;
        this.contents = contents;
    }
}
