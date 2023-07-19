package br.gama.itau.hospital.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.gama.itau.hospital.dto.PacienteDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("paciente")
    private List<Atendimento> atendimentos;

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.cpf = pacienteDTO.getCpf();
        this.telefone = pacienteDTO.getTelefone();
    }

    public Paciente(long id) {
        this.id = id;
    }

}
