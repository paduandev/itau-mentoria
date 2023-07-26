package br.gama.atendimentoservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {
    private long id;
    private String nome;
    private String cpf;
    private String telefone;

}
