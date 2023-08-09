package br.gama.hexagonal.domain.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gama.hexagonal.application.port.in.AccountOperation;
import br.gama.hexagonal.domain.model.Account;
import br.gama.hexagonal.infrastructure.port.out.AccountUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountOperation {

    private final AccountUseCase repository;

    @Override
    public Account create(String owner) {
        return repository.save(Account.builder().owner(owner).build());
    }

    @Override
    public boolean deposit(long idAccount, BigDecimal value) {
        Optional<Account> accountOptional = repository.load(idAccount);
        if(accountOptional.isEmpty()) {
            return false;
        }
        if(accountOptional.get().deposit(value)) {
            repository.save(accountOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(long idAccount, BigDecimal value) {
        Optional<Account> accountOptional = repository.load(idAccount);
        if(accountOptional.isEmpty()) {
            return false;
        }
        if(accountOptional.get().withdraw(value)) {
            repository.save(accountOptional.get());
            return true;
        }
        return false;
    }

}
