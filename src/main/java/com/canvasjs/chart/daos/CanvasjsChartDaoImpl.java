package com.canvasjs.chart.daos;

import com.canvasjs.chart.data.HistoricalExchangeData;
import com.canvasjs.chart.data.TrendLineData;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

    @Override
    public String getHistoricalExchangeData() throws IOException {
        return HistoricalExchangeData.getJsonData();
    }

    @Override
    public void setHisoricalExchangeData(String exchangeFrom, String exchangeTo) throws IOException {
        HistoricalExchangeData.setJsonData(exchangeFrom, exchangeTo);
    }

    @Override
    public String getTrendLineData() throws IOException {
        return TrendLineData.getTrendLineDataList();
    }

    public void setTrednLineData(String exchangeFrom, String exchangeTo) throws IOException {
        TrendLineData.setTrendLineDataList(exchangeFrom, exchangeTo);
    }

    public String getModeLineData() throws IOException {
        return TrendLineData.getTrendLineDataList();
    }

    public void setModeLineData(String exchangeFrom, String exchangeTo) throws IOException {
        TrendLineData.setTrendLineDataList(exchangeFrom, exchangeTo);
    }



}