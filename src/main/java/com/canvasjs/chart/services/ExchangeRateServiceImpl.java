package com.canvasjs.chart.services;

import com.canvasjs.chart.daos.ExchangeRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    
    private ExchangeRateDao exchangeDao;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateDao exchangeDao){
        this.exchangeDao = exchangeDao;
    }

    @Override
    public void setExchangeDao(String exchangeFrom, String exchangeTo) throws IOException {
        exchangeDao.setExchangeData(exchangeFrom, exchangeTo);
    }

    @Override
    public String getExchangeDao() throws IOException {
        return exchangeDao.getExchangeData();
    }
}
