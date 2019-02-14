package com.fork.cash.services.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${format.date}")
    public String appDatePattern;
//    @Value("${fast-add.request-batch-type}")
//    public String fastAddReqBatchType;
//    @Value("${fast-add.request-type}")
//    public String fastAddReType;
//    @Value("${fast-add.security-limit}")
//    private long fastAddSecurityLimit;

    public String getAppDatePattern() {
        return appDatePattern;
    }
//
//    public String getFastAddReqBatchType() {
//        return fastAddReqBatchType;
//    }
//
//    public String getFastAddReType() {
//        return fastAddReType;
//    }
//
//    public long getFastAddSecurityLimit() {
//        return fastAddSecurityLimit;
//    }
}
