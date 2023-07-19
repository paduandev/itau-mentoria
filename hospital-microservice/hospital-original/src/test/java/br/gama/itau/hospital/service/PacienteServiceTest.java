package br.gama.itau.hospital.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.hospital.dto.PacienteDTO;
import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.PacienteRepo;
import br.gama.itau.hospital.util.GeneratePaciente;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService service;

    @Mock
    private PacienteRepo repo;

    @Test
    public void getPaciente_returnPaciente_whenPacienteExist() {
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(GeneratePaciente.pacienteId1());
        pacientes.add(GeneratePaciente.pacienteId2());

        BDDMockito.when(repo.findById(any(Long.class))).thenReturn(Optional.of(GeneratePaciente.pacienteId1()));

        Optional<PacienteDTO> pacienteFound = service.getById(GeneratePaciente.pacienteId1().getId());

        assertThat(pacienteFound.get()).isNotNull();
        assertThat(pacienteFound.get().getId()).isEqualTo(GeneratePaciente.pacienteId1().getId());
    }

}
