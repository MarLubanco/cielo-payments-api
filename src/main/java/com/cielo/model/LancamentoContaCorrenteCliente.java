package com.cielo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LancamentoContaCorrenteCliente {

    @Id
    @GeneratedValue
    private Integer id;
    private Double numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    @OneToOne(mappedBy = "lancamentoContaCorrenteCliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DomicilioBancario domicilioBancario;
    private String nomeTipoOperacao;
}
