package com.mls.mlsmoneyapi.repository;

import com.mls.mlsmoneyapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
