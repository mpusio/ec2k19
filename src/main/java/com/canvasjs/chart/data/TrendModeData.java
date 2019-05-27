package com.canvasjs.chart.data;

import org.json.JSONObject;

import java.io.IOException;

import static com.canvasjs.chart.useful.HandleJson.parseSpecificJSON;
import static com.canvasjs.chart.useful.HandleJson.readJsonFromUrl;

public class TrendModeData {

    private static JSONObject resources;

    static {
        try {
            resources = readJsonFromUrl("https://www.alphavantage.co/query?function=HT_TRENDMODE&symbol=USDJPY&interval=daily&series_type=close&apikey=5BH9VE5T22Y2EW49");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setTrendModeDataList(String exchangeFrom, String exchangeTo) throws IOException {
        String symbol = exchangeFrom + "" + exchangeTo;
        String apikey = "OSXGKBSLM61SZEI1";
        String adress = "https://www.alphavantage.co/query?function=HT_TRENDMODE&symbol=" +
                symbol + "&interval=daily&series_type=close&apikey=" + apikey;

        resources = readJsonFromUrl(adress);
    }

    public static String getTrendModeDataList() throws IOException {
        return parseSpecificJSON(resources, "Technical Analysis: HT_TRENDMODE", "TRENDMODE").toString();
    }
}