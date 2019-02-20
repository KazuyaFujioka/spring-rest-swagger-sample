package com.example.domain.model.film;

import com.example.domain.type.Description;

/**
 * フィルムタイトル
 */
public class Title {

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