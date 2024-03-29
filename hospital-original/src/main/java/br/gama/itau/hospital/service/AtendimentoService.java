package br.gama.itau.hospital.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gama.itau.hospital.dto.AtendimentoDTO;
import br.gama.itau.hospital.dto.NovoAtendimentoDTO;
import br.gama.itau.hospital.model.Atendimento;
import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.repo.AtendimentoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepo repo;

    public List<Atendimento> getAll() {
        return (List<Atendimento>) repo.findAll();
    }

    public Optional<AtendimentoDTO> getById(long id) {
        Optional<Atendimento> atendimentoOptional = repo.findById(id);
        if (atendimentoOptional.isPresent()) {
            return Optional.of(new AtendimentoDTO(atendimentoOptional.get()));
        }
        return Optional.empty();
    }

    public AtendimentoDTO create(NovoAtendimentoDTO novoAtendimentoDTO) {
        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(new Paciente(novoAtendimentoDTO.getIdPaciente()));
        atendimento.setData(LocalDate.now());
        atendimento.setExames(novoAtendimentoDTO.getExames());

        return new AtendimentoDTO(repo.save(atendimento));
    }

    public boolean close(long id, String medicamentos) {
        Optional<Atendimento> optional = repo.findById(id);
        if (optional.isPresent() && !optional.get().isFechado()) {
            optional.get().setMedicamentos(medicamentos);
            optional.get().setFechado(true);
            repo.save(optional.get());
            return true;
        }
        return false;
    }
}
