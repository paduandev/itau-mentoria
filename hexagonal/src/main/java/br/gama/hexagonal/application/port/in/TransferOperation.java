package br.gama.hexagonal.application.port.in;

import java.math.BigDecimal;
import java.util.Optional;

import br.gama.hexagonal.domain.model.Transfer;

public interface TransferOperation {
    public Optional<Transfer> tranfer(long idAccountSource, long idAccountTarged, BigDecimal value);
}
