package com.mls.mlsmoneyapi.repository;

import com.mls.mlsmoneyapi.model.Lancamento;
import com.mls.mlsmoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
