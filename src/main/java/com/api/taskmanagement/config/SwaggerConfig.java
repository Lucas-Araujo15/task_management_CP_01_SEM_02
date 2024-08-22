package com.api.taskmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApiConfiguration() {
//        String schemeName = "basicAuth";
//        String scheme = "basic";
        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement()
//                        .addList(schemeName)).components(new Components()
//                        .addSecuritySchemes(
//                                schemeName, new SecurityScheme()
//                                        .name(schemeName)
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .in(SecurityScheme.In.HEADER)
//                                        .scheme(scheme)
//                        )
//                )
                .info(new Info()
                        .title("Checkpoint 01 - Sistema de Gerenciamento de Tarefas")
                        .version("0.0.1")
                        .description(" O sistema permitirá que os usuários registrem, visualizem, atualizem e removam tarefas, além de gerenciar o status dessas tarefas (por exemplo, \"Em Andamento\", \"Concluída\", \"Pendente\"). Para garantir a segurança das informações, o sistema deve implementar autenticação utilizando JWT (JSON Web Token)")
                        .contact(new Contact()
                                .email("lucasaraujo4188@gmail.com")
                                .name("Lucas Araujo"))
                        .license(new License()));
    }
}
