package com.example.domain.type;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 金額
 */
public class Amount {

    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(value);
    }

    private Amount() {
    }
}