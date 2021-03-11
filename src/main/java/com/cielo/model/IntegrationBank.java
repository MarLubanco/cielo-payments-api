package com.cielo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class IntegrationBank {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "total_controle_lancamento_id", referencedColumnName = "id")
    private TotalControleLancamento totalControleLancamento;
    @OneToMany(mappedBy="integration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ControleLancamento> listaControleLancamento;
    private Integer indice;
    private Integer tamanhoPagina;
    private Integer totalElements;
}
