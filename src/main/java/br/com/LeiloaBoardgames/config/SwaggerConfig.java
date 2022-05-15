package br.com.LeiloaBoardgames.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("br.com.LeiloaBoardgames.controller"))
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("My REST API", "Some custom description of API.", "1.0", "Terms of service",
                new Contact("", "", ""), "License of API", "API license URL", Collections.emptyList());
    }
}