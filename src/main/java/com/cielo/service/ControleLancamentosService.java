package com.cielo.service;

import com.cielo.dto.DashboardResponse;
import com.cielo.dto.PercentPayment;
import com.cielo.model.ControleLancamento;
import com.cielo.repository.ControleLancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ControleLancamentosService {

    static final Integer PERCENT = 100;

    @Autowired
    private ControleLancamentoRepository controleLancamentoRepository;

    public List<ControleLancamento> findAll() {
        return controleLancamentoRepository.findAll();
    }

    public DashboardResponse getDashboard() {
        List<ControleLancamento> lancamentos = controleLancamentoRepository.findAll();
        List<ControleLancamento> lancamentosPagos = lancamentos.stream()
                .filter(controle -> controle.getLancamentoContaCorrenteCliente()
                        .getNomeSituacaoRemessa().equalsIgnoreCase("PAGO"))
                .collect(Collectors.toList());
        PercentPayment percentPayment = calculatesPercentagePaymentsPaid(lancamentos, lancamentosPagos);
        Map<String, List<Integer>> bankMorePopular = getBankMorePopular();
        return DashboardResponse.builder()
                .percentPayment(percentPayment)
                .bankMorePopular(bankMorePopular)
                .build();
    }

    public Map<String, List<Integer>> getBankMorePopular() {
        return controleLancamentoRepository.findAll().stream()
                .collect(Collectors.groupingBy(ControleLancamento::getNomeBanco,
                            Collectors.mapping(ControleLancamento::getId, Collectors.toList())));
    }

    public PercentPayment calculatesPercentagePaymentsPaid(List<ControleLancamento> lancamentos, List<ControleLancamento> payments) {
        int percent = payments.size() / lancamentos.size() * PERCENT;

        return PercentPayment.builder()
                .paymentsPaid(lancamentos.size())
                .percentPaid(percent)
                .totalPayments(lancamentos.size())
                .controleLancamentoList(payments)
                .build();
    }
}
