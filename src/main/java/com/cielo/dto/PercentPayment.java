package com.cielo.dto;

import com.cielo.model.ControleLancamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PercentPayment {

    private Double percentPaid;
    private Integer totalPayments;
    private Integer paymentsPaid;
    private List<ControleLancamento> controleLancamentoList;
}
