package br.gama.itau.hospital.util;

import br.gama.itau.hospital.model.Paciente;

public class GeneratePaciente {

    public static Paciente pacienteId1() {
        return Paciente.builder()
                .id(1)
                .nome("Paciente 1")
                .cpf("cpf 1")
                .telefone("telefone 1")
                .build();
    }

    public static Paciente pacienteId2() {
        return Paciente.builder()
                .id(2)
                .nome("Paciente 2")
                .cpf("cpf 2")
                .telefone("telefone 2")
                .build();
    }

    public static Paciente novoPaciente1() {
        return Paciente.builder()
                .nome("Paciente 1")
                .cpf("cpf 1")
                .telefone("telefone 1")
                .build();
    }

    public static Paciente novoPaciente2() {
        return Paciente.builder()
                .nome("Paciente 2")
                .cpf("cpf 2")
                .telefone("telefone 2")
                .build();
    }
}
