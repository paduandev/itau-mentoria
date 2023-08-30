package br.gama.hexagonal.application.port.in;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.gama.hexagonal.application.adapter.rest.dto.Historic;
import br.gama.hexagonal.domain.model.Transfer;

public interface TransferOperation {
    public Optional<Transfer> tranfer(long idAccountSource, long idAccountTarged, BigDecimal value);
    public List<Historic> historic(long idAccount, LocalDate dateFrom, LocalDate dateTo);
}
