package com.canvasjs.chart.controllers;

import com.canvasjs.chart.model.Exchange;
import com.canvasjs.chart.services.CanvasjsChartService;
import com.canvasjs.chart.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class ExchangeController {

    private ExchangeRateService exchangeService;
    private CanvasjsChartService canvasjsChartService;

    @Autowired
    public ExchangeController(ExchangeRateService exchangeService, CanvasjsChartService canvasjsChartService) {
        this.exchangeService = exchangeService;
        this.canvasjsChartService = canvasjsChartService;
    }

    @GetMapping("")
    public String getStarter(){
        return "starter";
    }

    @PostMapping("")
    public String postStarter(){
        return "index";
    }

    @GetMapping("/index")
    public String exchangeRateForm(Model model) {
        model.addAttribute("exchange", new Exchange());
        return "index";
    }

    @PostMapping("/index")
    public String exchangeSubmit(@ModelAttribute Exchange exchange) throws IOException {
        exchangeService.setExchangeDao(exchange.getCurrencyFrom(), exchange.getCurrencyTo());
        canvasjsChartService.setHistoricalExchange(exchange.getCurrencyFrom(), exchange.getCurrencyTo());
        canvasjsChartService.setTrednLine(exchange.getCurrencyFrom(), exchange.getCurrencyTo());
        canvasjsChartService.setModeLine(exchange.getCurrencyFrom(), exchange.getCurrencyTo());
        return "index";
    }
}
