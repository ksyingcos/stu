package com.stu.maven.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* 
 * Restful API 访问路径: 
 * http://IP:port/{context-path}/swagger-ui.html 
 * eg:http://localhost:8080/jd-config-web/swagger-ui.html 
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("rest")
        .apiInfo(apiInfo())
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("cn.evun.stu.maven.web.controller.rest"))
        .paths(PathSelectors.any()).build();
  }
  @Bean
  public Docket createControllerApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("controller")
        .apiInfo(apiInfo())
        .select()
        .apis(
            RequestHandlerSelectors.basePackage("cn.evun.stu.maven.web.controller"))
        .paths(PathSelectors.any()).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Spring 中使用Swagger2构建RESTful APIs").version("1.0").build();
  }
  
  public static void main(String[] args){
    String regex = "a.b.*.*.c.d";
    System.out.println("a.b..c.d".matches(regex));
  }
}
