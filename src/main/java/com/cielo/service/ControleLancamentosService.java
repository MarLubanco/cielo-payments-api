package com.cielo.service;

import com.cielo.dto.BankPopular;
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
                        .getNomeSituacaoRemessa().equals("Pago"))
                .collect(Collectors.toList());
        PercentPayment percentPayment = calculatesPercentagePaymentsPaid(lancamentos, lancamentosPagos);
        List<BankPopular> bankMorePopular = getBankMorePopular();
        return DashboardResponse.builder()
                .percentPayment(percentPayment)
                .bankMorePopular(bankMorePopular)
                .build();
    }

    public List<BankPopular> getBankMorePopular() {
        Map<String, List<Integer>> bankMorePopulars = controleLancamentoRepository.findAll().stream()
                .collect(Collectors.groupingBy(ControleLancamento::getNomeBanco,
                        Collectors.mapping(ControleLancamento::getId, Collectors.toList())));
        return bankMorePopulars.entrySet().stream()
                .map(bank -> new BankPopular(bank.getKey(), bank.getValue().size()))
                .collect(Collectors.toList());

    }

    public PercentPayment calculatesPercentagePaymentsPaid(List<ControleLancamento> lancamentos, List<ControleLancamento> payments) {
        double percent = Double.valueOf(payments.size()) / Double.valueOf(lancamentos.size()) * PERCENT;

        return PercentPayment.builder()
                .paymentsPaid(payments.size())
                .percentPaid(percent)
                .totalPayments(lancamentos.size())
                .controleLancamentoList(payments)
                .build();
    }
}
