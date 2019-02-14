package com.fork.cash.services.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${format.date}")
    public String appDatePattern;
    public String getAppDatePattern() {
        return appDatePattern;
    }

}
