package com.example.domain.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = DescriptionSerializer.class)
@JsonDeserialize(using = DescriptionDeserializer.class)
public class DescriptionMixin {
}
