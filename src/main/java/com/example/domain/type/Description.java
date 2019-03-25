package com.example.domain.type;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

/**
 * 説明文
 */
public class Description {

    @NotNull(message = "入力してください")
    @Length(max = 100, message = "{max}文字以内で入力してください")
    String value;

    public Description(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    private Description() {
    }
}