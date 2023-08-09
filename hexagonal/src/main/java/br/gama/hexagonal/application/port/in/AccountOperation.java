package br.gama.hexagonal.application.port.in;

import java.math.BigDecimal;

import br.gama.hexagonal.domain.model.Account;

public interface AccountOperation {
    Account create(String owner);
    boolean deposit(long idAccount, BigDecimal value);
    boolean withdraw(long idAccount, BigDecimal value);
}
