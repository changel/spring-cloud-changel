package com.changel.nacos.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author Chang.Tong
 * @Date 2021/2/6 18:39
 * @Version 1.0
 */
@EnableOpenApi
@Configuration
@EnableConfigurationProperties(SwaggerProperty.class)
public class SwaggerConfig {
    @Autowired
    private SwaggerProperty swaggerProperty;

    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.OAS_30))
                .apiInfo(this.apiInfo())
                .groupName(this.swaggerProperty.getGroupName())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.changel.major"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return (
                new ApiInfoBuilder())
                .title(this.swaggerProperty.getTitle())
                .version(this.swaggerProperty.getVersion())
                .description(this.swaggerProperty.getDescription())
                .contact(new Contact(this.swaggerProperty.getContactName(), this.swaggerProperty.getContactUrl(), this.swaggerProperty.getContactEmail()))
                .build();
    }
}
