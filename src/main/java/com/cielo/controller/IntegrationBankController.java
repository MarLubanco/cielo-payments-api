package com.cielo.controller;

import com.cielo.model.ControleLancamento;
import com.cielo.model.IntegrationBank;
import com.cielo.service.ControleLancamentosService;
import com.cielo.service.IntegrationBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/integrations")
public class IntegrationBankController {

    @Autowired
    private IntegrationBankService integrationBankService;
    @Autowired
    private ControleLancamentosService controleLancamentosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IntegrationBank saveIntegration(@RequestBody IntegrationBank integrationBank) {
        return integrationBankService.saveIntegration(integrationBank);
    }

}
