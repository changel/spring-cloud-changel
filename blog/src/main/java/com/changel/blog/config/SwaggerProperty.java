package com.changel.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 18:38
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "swagger")
@Component
public class SwaggerProperty {
    private String basePackage;
    private String groupName;
    private String title;
    private String version;
    private String description;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
}
