package com.cielo.service;

import com.cielo.CieloApplication;
import com.cielo.dto.DashboardResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CieloApplication.class)
public class ControleLancamentoServiceTest {

    @Autowired
    private ControleLancamentosService controleLancamentosService;

    @Test
    public void getBankMorePopular_ok() {
    }

    @Test
    public void getDashboard_ok() {

    }

    @Test
    public void calculatesPercentagePaymentsPaid_ok() {

    }
}
