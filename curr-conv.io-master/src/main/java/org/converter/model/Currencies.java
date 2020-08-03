package org.converter.model;

public enum Currencies {
    EUR("euro"),
    GBP("pound"),
    USD("dollar"),
    ETH("ethereum"),
    FKE("fke"),
    BTC("bitcoin");

    Currencies (String currency){this.currency = currency;}
    private final String currency;
    public String getCurrency() {return currency;}
}
