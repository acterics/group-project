package com.groupproject.image.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("imgproxy")
@Data
public class ImgproxyConfiguration {
    private String key;
    private String salt;
}