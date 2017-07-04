package com.chariot.shadow.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Trung Vu on 2017/07/04.
 */
@Component
@ConfigurationProperties("config")
@Data
public class CacheDuration {

    private Integer duration;
}
