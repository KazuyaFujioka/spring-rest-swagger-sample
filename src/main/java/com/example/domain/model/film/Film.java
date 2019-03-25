package com.example.domain.model.film;

import com.example.domain.type.Description;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * フィルム(作品)
 */
@ApiModel(description = "フィルム(作品)")
public class Film {

    /**
     * exampleを出す為にはモデルに色々と書かないとダメっぽい
     */

    @ApiModelProperty(value = "フィルムタイトル", example = "作品名が入る")
    @Valid
    Title title;

    public Film(Title title) {
        this.title = title;
    }

    // DB使う場合は不要
    public static Film prototype() {
        return new Film(new Title(new Description("作品名")));
    }

    @Override
    public String toString() {
        return "Film{" +
                "title=" + title +
                '}';
    }

    private Film() {
    }
}