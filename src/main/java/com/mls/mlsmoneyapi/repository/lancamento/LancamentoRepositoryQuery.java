package com.mls.mlsmoneyapi.repository.lancamento;

import com.mls.mlsmoneyapi.model.Lancamento;
import com.mls.mlsmoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
