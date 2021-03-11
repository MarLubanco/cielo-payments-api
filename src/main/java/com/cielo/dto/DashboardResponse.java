package com.cielo.dto;

import com.cielo.model.ControleLancamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DashboardResponse {

    private PercentPayment percentPayment;
    private Map<String, List<Integer>> bankMorePopular;
}
