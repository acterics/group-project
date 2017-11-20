package com.groupproject.productservice.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("constants")
@Data
public class ConstantConfiguration {
    private Integer page;
    private Integer size;
}
