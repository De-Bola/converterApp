package org.converter.model;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Currency {

    private Map<String, Double> rates = new HashMap<>();

    public BigDecimal getExchangeRate() {
        return new BigDecimal(0.0);
    }

    private Map<String, Double> getCSVData() {
        String pathToCSV = "C:\\Users\\admin\\Desktop\\currconv.io\\src\\main\\resources\\BE užduoties priedas (Data annex).csv";
        CSVReader csvReader;
        String[] lineOfData;
        Map<String, Double> dataInput = new HashMap<>();

        try {
            csvReader = new CSVReader(new FileReader(pathToCSV));
            while ((lineOfData = csvReader.readNext()) != null && (lineOfData.length) == 2) {
                String value = reformatString(lineOfData[1]);
                dataInput.put(lineOfData[0], Double.valueOf(value));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataInput;
    }

    private String reformatString(String str) {
        return (str.contains(",")) ? str.replace(",", ".") : str;
    }

    public Map<String, Double> getRates() {
        if(this.rates == null || this.rates.isEmpty()){
            setRates();
        }
        return this.rates;
    }

    private void setRates() {
        if(this.rates == null || this.rates.isEmpty()){
            this.rates = getCSVData();
        }
    }
}

