package br.gama.hexagonal.infrastructure.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.gama.hexagonal.domain.model.Account;
import br.gama.hexagonal.infrastructure.jpa.AccountEntity;
import br.gama.hexagonal.infrastructure.jpa.AccountRepoJPA;
import br.gama.hexagonal.infrastructure.port.out.AccountUseCase;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements AccountUseCase {

    private final AccountRepoJPA repo;

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = new AccountEntity(account);
        Account newAccount = repo.save(accountEntity).toAccount();
        return newAccount;
    }

    @Override
    public Optional<Account> load(long idAccount) {
        Optional<AccountEntity> accountEntity =  repo.findById(idAccount);
        if(accountEntity.isPresent()) {
            return  Optional.of(accountEntity.get().toAccount());
        }
        return Optional.empty();
    }
    
}
