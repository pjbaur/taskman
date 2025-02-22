package me.paulbaur.taskman.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI taskManagerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Manager API")
                        .description("Task Manager API implemented with Spring Boot")
                        .version("v1.0.0")
                        .license(new License()
                                .name("MIT")
                                .url("http://springdoc.org"))
                        .contact(new Contact()
                            .name("Paul Baur")
                            .email("paul.baur@gmail.com")
                            .url("https://www.linkedin.com/in/paul-baur/")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Repository")
                        .url("https://github.com/pjbaur/taskman"));
    }
}
