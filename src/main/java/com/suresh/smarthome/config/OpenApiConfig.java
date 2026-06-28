package com.suresh.smarthome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI smartHomeOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Smart Home Backend API")
                        .description("REST APIs for the Smart Home IoT platform.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Suresh Ragam")
                                .email("suresh.ragam@icloud.com"))
                        .license(new License()
                                .name("MIT License")));
    }

}