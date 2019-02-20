package com.example.domain.type;

/**
 * 説明文
 */
public class Description {

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