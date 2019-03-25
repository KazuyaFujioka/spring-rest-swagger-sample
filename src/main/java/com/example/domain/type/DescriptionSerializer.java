package com.example.domain.type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

class DescriptionSerializer extends JsonSerializer<Description> {

    @Override
    public void serialize(Description description,
                          JsonGenerator generator,
                          SerializerProvider serializers) throws IOException {
        generator.writeString(description.toString());
    }
}