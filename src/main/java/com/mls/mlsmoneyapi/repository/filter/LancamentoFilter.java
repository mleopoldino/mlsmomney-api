package com.mls.mlsmoneyapi.repository.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LancamentoFilter {

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimentoDe;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimentoAte;

}
