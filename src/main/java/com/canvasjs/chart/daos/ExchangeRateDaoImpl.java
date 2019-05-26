package com.canvasjs.chart.daos;

import com.canvasjs.chart.data.ExchangeRateData;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ExchangeRateDaoImpl implements ExchangeRateDao {
    public void setExchangeData(String exchangeFrom, String exchangeTo) throws IOException {
        ExchangeRateData.setExchangeRate(exchangeFrom, exchangeTo);
    }

    public String getExchangeData(){
        return ExchangeRateData.getExchangeRate();
    }
}
