package com.liuhx.apidemo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "third.test")
public class ThirdTestServiceProperties {

    private String rootUri;
    private String pingUri;
}
