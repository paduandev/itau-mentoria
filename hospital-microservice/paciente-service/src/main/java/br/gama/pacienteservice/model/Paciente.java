package br.gama.pacienteservice.model;

import java.util.List;

import br.gama.pacienteservice.dto.AtendimentoDTO;
import br.gama.pacienteservice.dto.PacienteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    private String nome;

    @Column(length = 15, unique = true)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Transient // dado "calculado", não e persistido no Banco de Dados
    private List<AtendimentoDTO> atendimentos;

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.cpf = pacienteDTO.getCpf();
        this.telefone = pacienteDTO.getTelefone();
    }

    public Paciente(long id) {
        this.id = id;
    }

}
