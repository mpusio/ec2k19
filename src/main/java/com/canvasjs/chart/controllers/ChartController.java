package com.canvasjs.chart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.canvasjs.chart.services.CanvasjsChartService;


@Controller
@RequestMapping("/restfull-service")
public class ChartController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CanvasjsChartService canvasjsChartService;

    @Autowired
    public ChartController(CanvasjsChartService canvasjsChartService){
        this.canvasjsChartService = canvasjsChartService;
    }

    @GetMapping("/historical-exchange-data.json")
    public @ResponseBody String getHistoricalExchangeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return canvasjsChartService.getHistoricalExchange();
    }

    @GetMapping("/trend-line.json")
    public @ResponseBody String getTrendLineData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return canvasjsChartService.getTrendLine();
    }

    @GetMapping("/mode-line.json")
    public @ResponseBody String getModeLineData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return canvasjsChartService.getModeLine();
    }



}                        