package com.capitole.inditex.pricingms.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration class for the Pricing Service API.configuracion del aplication del swagger y bel contextaplication y un context path
 * This class sets up the OpenAPI documentation for the service.
 */
@Configuration
@OpenAPIDefinition(servers = @Server(url = "${server.servlet.context-path}", description = "Pricing Service API"))
public class SwaggerConfig {

    /**
     * Bean definition for OpenAPI documentation.
     * This method creates an OpenAPI instance with service information.
     *
     * @return OpenAPI instance with service information
     */
    @Bean
    public OpenAPI pricingServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pricing Service API")
                        .version("1.0")
                        .description("API for querying product prices by brand and application date."));
    }

}