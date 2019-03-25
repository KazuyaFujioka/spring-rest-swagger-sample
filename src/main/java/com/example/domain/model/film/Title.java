package com.example.domain.model.film;

import com.example.domain.type.Description;

import javax.validation.Valid;

/**
 * フィルムタイトル
 */
public class Title {

    @Valid
    Description name;

    Title(Description name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    private Title() {
    }
}