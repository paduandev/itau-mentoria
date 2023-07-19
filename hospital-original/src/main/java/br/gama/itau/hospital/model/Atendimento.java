package br.gama.itau.hospital.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate data;
    private String exames;
    private String medicamentos;
    private boolean fechado;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    @JsonIgnoreProperties("atendimentos")
    private Paciente paciente;

}
