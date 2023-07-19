package br.gama.itau.hospital.dto;

import br.gama.itau.hospital.model.Paciente;
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

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.telefone = paciente.getTelefone();
    }
}
