package com.mls.mlsmoneyapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    @Column(name = "data_vencimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

    private BigDecimal valor;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;

}
