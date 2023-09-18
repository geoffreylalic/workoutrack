package com.springboot.workoutrack.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public final class Constant {
    public static final String apiPrefix = "api/v1/";

    @Value("${secret.key}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }
}
