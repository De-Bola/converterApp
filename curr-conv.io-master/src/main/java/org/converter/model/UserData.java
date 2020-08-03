package org.converter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UserData {
    private BigDecimal quantity;
    private String initCurrency;
    private String finCurrency;
    private BigDecimal result;

    public UserData(BigDecimal quantity, String initCurrency, String finCurrency) {
        this.quantity = quantity;
        this.initCurrency = initCurrency;
        this.finCurrency = finCurrency;
    }
}
