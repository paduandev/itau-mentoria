package br.gama.itau.hospital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoAtendimentoDTO {
    private long idPaciente;
    private String exames;
}
