package com.pessoas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pessoas.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Pessoa - Documentação")
                .description("Um exemplo de aplicação Spring Boot, uma API simples para gerenciar Pessoas")
                .version("1.0.0")
                .license("Licença Apache V2")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new springfox.documentation.service.Contact("Marceli Lausch", "https://www.linkedin.com/in/marcelilausch/", "marcelilausch@gmail.com"))
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.LIST) // or DocExpansion.NONE or DocExpansion.FULL
                .defaultModelsExpandDepth(-1)//para sumir models
                .defaultModelExpandDepth(-1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .build();
    }
}
