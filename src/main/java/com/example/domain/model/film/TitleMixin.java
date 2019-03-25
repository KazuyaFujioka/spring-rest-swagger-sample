package com.example.domain.model.film;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = TitleSerializer.class)
@JsonDeserialize(using = TitleDeserializer.class)
public class TitleMixin {
}