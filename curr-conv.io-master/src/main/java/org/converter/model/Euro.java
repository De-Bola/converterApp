package org.converter.model;

import java.math.BigDecimal;
import java.util.Map;

public class Euro extends  Currency {
    @Override
    public Map<String, Double> getRates() {
        return super.getRates();
    }

    @Override
    public BigDecimal getExchangeRate() {
        Double rate;
        rate = getRates().get(String.valueOf(Currencies.EUR));
        return BigDecimal.valueOf(rate);
    }
}
