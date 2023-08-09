package br.gama.hexagonal.infrastructure.port.out;

import java.util.Optional;

import br.gama.hexagonal.domain.model.Account;

public interface AccountUseCase {
    Account save(Account account);
    Optional<Account> load(long idAccount);
}
