package org.converter.model;

import java.math.BigDecimal;
import java.util.Map;

public class Ethereum extends Currency {
    @Override
    public BigDecimal getExchangeRate() {
        Double rate;
        rate = getRates().get(String.valueOf(Currencies.ETH));
        return BigDecimal.valueOf(rate);
    }

    @Override
    public Map<String, Double> getRates() {
        return super.getRates();
    }
}
