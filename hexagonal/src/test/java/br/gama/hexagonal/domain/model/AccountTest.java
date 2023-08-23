package br.gama.hexagonal.domain.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    void deposit_shouldChangeBalance_whenValueIsValid() {
        Account account = Account.builder().number(1).owner("Owner").build();

        account.deposit(BigDecimal.TEN);

        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.TEN);
    }

    @Test
    void deposit_shouldNotChangeBalance_whenValueIsInvalid() {
        Account account = Account.builder().number(1).owner("Owner").build();

        account.deposit(BigDecimal.TEN.negate());

        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.ZERO);
    }


    @Test
    void withdraw_shouldChangeBalance_whenValueIsValid() {
        long accountNumber = 1;
        Account account = Account.builder().number(accountNumber).owner("Owner").build();
        account.deposit(BigDecimal.TEN);

        account.withdraw(BigDecimal.valueOf(5));

        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.valueOf(5));
    }


    @Test
    void withdraw_shouldNotChangeBalance_whenValueIsInvalid() {
        long accountNumber = 1;
        Account account = Account.builder().number(accountNumber).owner("Owner").build();
        account.deposit(BigDecimal.TEN);

        account.withdraw(BigDecimal.valueOf(5).negate());

        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.TEN);
    }

    
    @Test
    void withdraw_shouldNotChangeBalance_whenValueGreaterThanBalance() {
        long accountNumber = 1;
        Account account = Account.builder().number(accountNumber).owner("Owner").build();
        account.deposit(BigDecimal.TEN);

        account.withdraw(BigDecimal.valueOf(50));

        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.TEN);
    }

}
