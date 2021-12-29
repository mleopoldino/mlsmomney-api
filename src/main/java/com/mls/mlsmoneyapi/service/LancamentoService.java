package com.mls.mlsmoneyapi.service;

import com.mls.mlsmoneyapi.model.Lancamento;
import com.mls.mlsmoneyapi.model.Pessoa;
import com.mls.mlsmoneyapi.repository.LancamentoRepository;
import com.mls.mlsmoneyapi.repository.PessoaRepository;
import com.mls.mlsmoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();

        if(pessoa == null || pessoa.isInativo()){
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }
}
