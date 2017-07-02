package com.chariot.shadow.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Trung Vu on 2017/06/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCollectionJson {

    private List<NewsJson> newsCollection;
}
