package com.cielo.controller;

import com.cielo.dto.DashboardResponse;
import com.cielo.model.ControleLancamento;
import com.cielo.service.ControleLancamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class ControleLancamentosController {

    @Autowired
    private ControleLancamentosService controleLancamentosService;

    @GetMapping
    public List<ControleLancamento> findAllLancamentos() {
       return controleLancamentosService.findAll();
    }

    @CrossOrigin
    @GetMapping("/porcentagem-pagos")
    public DashboardResponse findPercentPaymentPaid() {
        return controleLancamentosService.getDashboard();
    }
}
