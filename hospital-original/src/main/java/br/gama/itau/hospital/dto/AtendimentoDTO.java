package br.gama.itau.hospital.dto;

import java.time.LocalDate;

import br.gama.itau.hospital.model.Atendimento;
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

    public AtendimentoDTO(Atendimento atendimento) {
        this.id = atendimento.getId();
        this.data = atendimento.getData();
        this.exames = atendimento.getExames();
        this.medicamentos = atendimento.getMedicamentos();
        this.fechado = atendimento.isFechado();
        this.idPaciente = atendimento.getPaciente().getId();
    }

}
