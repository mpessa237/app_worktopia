package com.example.worktopia.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.StandardCharsets;

@OpenAPIDefinition(
        info = @Info(

                title = "GESTION MENTORAT VIRTUEL APIs",
                description = "Gestion Mentorat virtuel App APIs ",
                termsOfService = "&copy; TECHDREAMER",
                version = "v1"
        )
)


public class OpenApiConfig {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        return converter;
    }
}