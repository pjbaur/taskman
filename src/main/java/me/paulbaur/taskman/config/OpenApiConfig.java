package me.paulbaur.taskman.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Task Manager API",
        version = "1.0",
        description = "Backend REST API for a Task Manager application"))
public class OpenApiConfig {

    @Bean
    public OpenAPI taskManagerOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Task Manager API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Paul Baur")
                                .email("paul.baur@gmail.com"))
                        .description("Task Manager API Documentation"));
    }
}
