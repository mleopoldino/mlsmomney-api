package com.mls.mlsmoneyapi.repository.lancamento;

import com.mls.mlsmoneyapi.model.Lancamento;
import com.mls.mlsmoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
