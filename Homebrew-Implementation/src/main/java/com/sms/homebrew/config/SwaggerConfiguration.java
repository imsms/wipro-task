package com.sms.homebrew.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sms.homebrew.Constant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sathish kumar
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * 
     * Instantiates a new SwaggerConfig.java
     */
    SwaggerConfiguration() {
        // Default constructor
    }

    @Bean
    public Docket api() {
        List<springfox.documentation.service.Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder().name(Constant.API_TITLE).description(Constant.API_DESCRIPTION)
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build());

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.sms.homebrew.controller")).paths(PathSelectors.any())
                .build().apiInfo(apiInfo()).globalOperationParameters(parameters);
    }

    /**
     * 
     * Method - apiInfo to set the title, description and build version in order to
     * display in Swagger
     *
     * @param @return
     *            @throws
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(Constant.API_TITLE).description(Constant.API_DESCRIPTION)
                .version(Constant.VERSION).build();
    }
}