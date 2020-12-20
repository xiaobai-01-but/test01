package com.huawei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.any;

/**
 * @Description:
 * @author: sun
 * @date: 2020年12月11日 19:55
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.huawei.dao"})
@EnableSwagger2//开启swagger2
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }
    @Bean
    public Docket petApi() {
        HashSet<String> strings = new HashSet<>();
        strings.add("application/json");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("full-petstore-api")
                .apiInfo(apiInfo())
                //设置成全局返回 application/json
                .produces(strings)
                .select()
                //设置扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.huawei.controller"))
                //设置控制的路径匹配
                .paths(any())
                .build();
        //.securitySchemes(Collections.singletonList(oauth()))
        //.securityContexts(Collections.singletonList(securityContext()));
    }

    //设置匹配的路径
//    private Predicate<String> petstorePaths() {
//        return regex(".*/api/pet.*")
//                .or(regex(".*/api/user.*")
//                        .or(regex(".*/api/store.*")));
//    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("黑马swagger案例")
                .description("本文描述了黑马95期的swaggerAPI文档")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("liujianghua", "http://www.itheima.com", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
