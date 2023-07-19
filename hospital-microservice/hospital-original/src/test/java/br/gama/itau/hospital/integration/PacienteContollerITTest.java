package br.gama.itau.hospital.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.PacienteRepo;
import br.gama.itau.hospital.util.GeneratePaciente;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteContollerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PacienteRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }

    @Test
    public void getById_returnPaciente_whenPacienteExist() throws Exception {
        Paciente pacientSaved = repo.save(GeneratePaciente.novoPaciente1());
        String url = "/paciente/" + pacientSaved.getId();
        ResultActions retorno = mockMvc
                .perform(get(url).contentType(MediaType.APPLICATION_JSON));

        retorno.andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", CoreMatchers.is(GeneratePaciente.novoPaciente1().getNome())));
    }

}
