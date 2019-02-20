package com.example;

import com.example.domain.model.film.Title;
import com.example.domain.type.Amount;
import com.example.domain.type.Description;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import static com.google.common.base.Predicates.containsPattern;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
class SpringfoxConfiguration {

    @Bean
    Docket document() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(createBasePackage())
                .paths(createPaths())
                .build()
                .directModelSubstitute(Amount.class, Integer.class)
                .directModelSubstitute(Description.class, String.class)
                .directModelSubstitute(Title.class, String.class);
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("タイトル")
                .description("説明文")
                .version("APIバージョン")
                .termsOfServiceUrl("利用規約URL")
                .contact(new Contact("連絡先名", "連絡先URL", "連絡先メールアドレス"))
                .license("ライセンス")
                .licenseUrl("ライセンスURL")
                .extensions(Collections.emptyList())
                .build();
    }

    private Predicate<RequestHandler> createBasePackage() {
        return basePackage("com.example.api");
    }

    private Predicate<String> createPaths() {
        return or(
                containsPattern("/v1.*")
        );
    }
}