package com.microservice;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WebIntializer{

    public static void main(String[] args) {
        SpringApplication.run(WebIntializer.class, args);
    }

    
   @Bean
   public Docket personApi() {
       return new Docket(DocumentationType.SWAGGER_2)               
               .apiInfo(apiInfo())
               .select()               
               .paths(regex ("/microservice.*"))
               .build();
   }
    
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Predix MicroServices")
               .description("MicroServices of Pharma")
               .contact(new Contact("","", "santhoshkumar.konda@cognizant.com"))
               .version("1.0")
               .build();
   }   
   
}
