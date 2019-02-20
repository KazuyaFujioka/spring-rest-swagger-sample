package com.example;

import com.example.domain.model.film.Title;
import com.example.domain.model.film.TitleSerializer;
import com.example.domain.type.Amount;
import com.example.domain.type.AmountSerializer;
import com.example.domain.type.Description;
import com.example.domain.type.DescriptionSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;

@Configuration
class WebConfiguration implements WebMvcConfigurer {

    @Primary
    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NON_PRIVATE);
        objectMapper.setVisibility(PropertyAccessor.GETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER,JsonAutoDetect.Visibility.NONE);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();

        module.addSerializer(Amount.class, new AmountSerializer());
        module.addSerializer(Description.class, new DescriptionSerializer());

        module.addSerializer(Title.class, new TitleSerializer());

        objectMapper.registerModule(module);

        return objectMapper;
    }

    @Bean
    HttpMessageConverters customConverters() {
        HttpMessageConverter<?> stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        HttpMessageConverter<?> mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper());
        return new HttpMessageConverters(stringHttpMessageConverter, mappingJackson2HttpMessageConverter);
    }
}