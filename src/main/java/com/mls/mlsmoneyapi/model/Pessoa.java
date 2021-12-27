package com.mls.mlsmoneyapi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NotNull
    @Column(name="nome")
    private String nome;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name="ativo")
    private Boolean ativo;
}
