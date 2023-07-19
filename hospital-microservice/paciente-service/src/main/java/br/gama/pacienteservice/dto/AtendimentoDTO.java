package br.gama.pacienteservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoDTO {
    private long id;
    private long idPaciente;
    private LocalDate data;
    private String exames;
    private String medicamentos;
    private boolean fechado;

}
