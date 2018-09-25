package com.unonothing.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "uNoNother", "github.com:uNoNothing", "uNoNothing@users.noreply.github.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "project20180921",
            "project to practice best practices",
            "v1",
            "urn:tos",
            DEFAULT_CONTACT,
            "MIT License",
            "https://github.com/uNoNothing/project20180921/blob/master/LICENSE",
            Collections.emptyList()
    );

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}
