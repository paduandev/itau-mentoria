package br.gama.atendimentoservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoAtendimentoDTO {
    private long idPaciente;
    private String exames;
}
