package com.mls.mlsmoneyapi.repository;

import com.mls.mlsmoneyapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
