package org.converter.service;

import org.converter.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
public class ConverterService {

    private UserData userData = new UserData();

    public UserData setUserData(UserData dataFromPostMethod){
        this.userData.setQuantity(dataFromPostMethod.getQuantity());
        this.userData.setInitCurrency(dataFromPostMethod.getInitCurrency());
        this.userData.setFinCurrency(dataFromPostMethod.getFinCurrency());
        this.userData.setResult(new BigDecimal(0));
        return this.userData;
    }

    public BigDecimal calculateFinalAmount(UserData userData) {

        BigDecimal initRate;
        BigDecimal exchangeRate;
        BigDecimal finalRate;
        BigDecimal output = new BigDecimal(1.0);
        initRate = initRateFactory();
        finalRate = finalRateFactory();
        try{
            exchangeRate = initRate.divide(finalRate, MathContext.DECIMAL128);
            output = userData.getQuantity().multiply(exchangeRate, MathContext.DECIMAL128);
        } catch (ArithmeticException e){
            e.getMessage();
        }
        userData.setResult(output);
        return userData.getResult();
    }

    private UserData getUserData(){
        return this.userData;
    }

    private BigDecimal initRateFactory(){
        BigDecimal initialRate;

        if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.EUR.getCurrency())){
            Euro euro = new Euro();
            initialRate = euro.getExchangeRate();
        }else if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.USD.getCurrency())){
            Dollar dollar = new Dollar();
            initialRate = dollar.getExchangeRate();
        }else if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.GBP.getCurrency())){
            Pound pound = new Pound();
            initialRate = pound.getExchangeRate();
        }else if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.ETH.getCurrency())){
            Ethereum ethereum = new Ethereum();
            initialRate = ethereum.getExchangeRate();
        }else if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.FKE.getCurrency())){
            FKE fke = new FKE();
            initialRate = fke.getExchangeRate();
        }else if(getUserData().getInitCurrency().equalsIgnoreCase(Currencies.BTC.getCurrency())){
            Bitcoin bitcoin = new Bitcoin();
            initialRate = bitcoin.getExchangeRate();
        }else {
            Currency currency = new Currency();
            initialRate = currency.getExchangeRate();
        }
        return initialRate;
    }

    private BigDecimal finalRateFactory() {
        BigDecimal finalRate;

        if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.EUR.getCurrency())){
            Euro euro = new Euro();
            finalRate = euro.getExchangeRate();
        }else if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.USD.getCurrency())){
            Dollar dollar = new Dollar();
            finalRate = dollar.getExchangeRate();
        }else if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.GBP.getCurrency())){
            Pound pound = new Pound();
            finalRate = pound.getExchangeRate();
        }else if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.ETH.getCurrency())){
            Ethereum ethereum = new Ethereum();
            finalRate = ethereum.getExchangeRate();
        }else if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.FKE.getCurrency())){
            FKE fke = new FKE();
            finalRate = fke.getExchangeRate();
        }else if(getUserData().getFinCurrency().equalsIgnoreCase(Currencies.BTC.getCurrency())){
            Bitcoin bitcoin = new Bitcoin();
            finalRate = bitcoin.getExchangeRate();
        }else {
            Currency currency = new Currency();
            finalRate = currency.getExchangeRate();
        }
        return finalRate;
    }
}

