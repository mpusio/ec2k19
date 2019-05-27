package com.canvasjs.chart.model;


import com.canvasjs.chart.data.ExchangeRateData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

@Component
public class Exchange {

    private String currencyFrom = "USD";
    private String currencyTo = "JPY";

    public Exchange(){

    }

    public Exchange(String currencyFrom, String currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {

        this.currencyTo = currencyTo;
    }

    public void setExchangeRate() throws IOException {
        ExchangeRateData.setExchangeRate(currencyFrom, currencyTo);
    }

    public String getExchangeRate() throws IOException {
        return ExchangeRateData.getExchangeRate();
    }
//
//    public void setCanvasjsChart() throws IOException {
//        canvasjsChartService.getHistoricalExchange(currencyFrom, currencyTo);
//    }


}
