package com.fadv.myapplication.dto;

import java.util.List;

/**
 * Created by Amit Rawat  on 18-02-2021.
 */
public class CountryDTO {
    private String name;
    private List<String> callingCodes;
    private List<CurrencyCode> currencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<CurrencyCode> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyCode> currencies) {
        this.currencies = currencies;
    }
}
