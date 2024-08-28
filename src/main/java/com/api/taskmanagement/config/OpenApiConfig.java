package com.api.taskmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Lucas", email = "lucasaraujo4188@gmail.com", url =
                "http://wwww.fiap.com.br"),
                description = "Especificação da API do sistema de gerenciamento de tarefas",
                title = "Task Management API",
                version = "1.0",
                license = @License(name = ""),
                termsOfService = "Termos"
        ),
        servers = {
                @Server(description = "Dev Env", url = "http://localhost:8080"),
                @Server(description = "Prod Env", url = "http://taskmanagement.com.br")
        },
        security =  @SecurityRequirement(name = "bearerJWT")
)
@SecurityScheme(
        name="bearerJWT",
        description = "Autenticação básica JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {

}
