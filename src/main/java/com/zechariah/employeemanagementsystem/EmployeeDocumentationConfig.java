package com.zechariah.employeemanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class EmployeeDocumentationConfig {

    public static final Contact SUPPORTED_CONTACTS = new Contact("Zechariah", "https://www.codexive.com", "codesupport@mail.com");

    @Bean
    public Docket docketApiDocs(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInformation());
    }

    private ApiInfo apiInformation() {
        return new ApiInfoBuilder()
                .title("Employee Management System Api Documentation")
                .description("All The Available Documentation Information For Employee Management System With Swagger Documentation")
                .contact(SUPPORTED_CONTACTS)
                .license("Employee Management System Licence")
                .version("2.0")
                .build();
    }

}
