package com.groupproject.image.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("imgproxy")
public class ImgproxyConfiguration {
    private String key;
    private String salt;

    public String getKey() {
        return key;
    }

    public String getSalt() {
        return salt;
    }

}