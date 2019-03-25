package com.example.domain.model.film;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

class TitleSerializer extends JsonSerializer<Title> {

    @Override
    public void serialize(Title title,
                          JsonGenerator generator,
                          SerializerProvider serializers) throws IOException {
        generator.writeObject(title.name);
    }
}