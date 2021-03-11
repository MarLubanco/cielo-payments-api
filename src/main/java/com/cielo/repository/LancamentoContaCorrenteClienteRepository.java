package com.cielo.repository;

import com.cielo.model.LancamentoContaCorrenteCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoContaCorrenteClienteRepository
        extends JpaRepository<LancamentoContaCorrenteCliente, Integer> {
}
