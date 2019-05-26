//CanvasjsChartServiceImpl.java
package com.canvasjs.chart.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.canvasjs.chart.daos.CanvasjsChartDao;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
    private CanvasjsChartDao canvasjsChartDao;

    @Autowired
    public CanvasjsChartServiceImpl(CanvasjsChartDao canvasjsChartDao) {
        this.canvasjsChartDao = canvasjsChartDao;
    }

    @Override
    public String getTrendLine() throws IOException {
        return canvasjsChartDao.getTrendLineData();
    }

    @Override
    public void setTrednLine(String exchangeFrom, String exchangeTo) throws IOException {
        canvasjsChartDao.setTrednLineData(exchangeFrom, exchangeTo);
    }

    @Override
    public String getModeLine() throws IOException {
        return canvasjsChartDao.getModeLineData();
    }

    @Override
    public void setModeLine(String exchangeFrom, String exchangeTo) throws IOException {
        canvasjsChartDao.setModeLineData(exchangeFrom, exchangeTo);
    }

    @Override
    public String getHistoricalExchange() throws IOException {
        return canvasjsChartDao.getHistoricalExchangeData();
    }

    @Override
    public void setHistoricalExchange(String exchangeFrom, String exchangeTo) throws IOException {
        canvasjsChartDao.setHisoricalExchangeData(exchangeFrom, exchangeTo);
    }


}                        