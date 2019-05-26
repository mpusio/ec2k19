package com.canvasjs.chart.useful;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class HandleJson {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
        finally {
            is.close();
        }
    }

    public static JSONArray parseSpecificJSON(JSONObject resources, String parse, String parseDeeper){
        JSONObject subresources = resources.getJSONObject(parse);
        Set<String> dates = subresources.keySet();
        ArrayList<String> sortedDate = new ArrayList<String>(dates);
        Collections.sort(sortedDate);
        JSONArray jsonArray = new JSONArray();

        for (String date : sortedDate){
            String closePrice = subresources.getJSONObject(date).getString(parseDeeper);
            double closePriceInt = Double.parseDouble(closePrice);
            JSONObject tempObj = new JSONObject().put("price", closePriceInt).put("date", date);
            jsonArray.put(tempObj);
        }
        return jsonArray;
    }
}
