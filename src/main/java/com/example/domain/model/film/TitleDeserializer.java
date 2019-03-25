package com.example.domain.model.film;

import com.example.domain.type.Description;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

class TitleDeserializer extends JsonDeserializer<Title> {

    @Override
    public Title deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        return new Title(new Description(node.asText()));
    }
}