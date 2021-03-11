package com.cielo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DomicilioBancario {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer codigoBanco;
    private Integer numeroAgencia;
    private String numeroContaCorrente;
    @OneToOne
    @MapsId
    @JoinColumn(name = "lancamento_ccc_id")
    private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;
}
