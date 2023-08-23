package br.gama.hexagonal.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.hexagonal.domain.model.Account;
import br.gama.hexagonal.infrastructure.port.out.AccountUseCase;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountUseCase repository;

    @Test
    void deposit_shouldChangeBalance_whenValueValid() {
        long accountNumber = 1;
        Account account = Account.builder().number(accountNumber).owner("Owner").build();

        Mockito.when(repository.load(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(account));

        boolean done = accountService.deposit(accountNumber, BigDecimal.TEN);

        assertThat(done).isTrue();
        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.TEN);
    }

    @Test
    void deposit_shouldReturnFalse_whenAccountNotExist() {
        long accountInvalidNumber = 0;

        Mockito.when(repository.load(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        boolean done = accountService.deposit(accountInvalidNumber, BigDecimal.TEN);

        assertThat(done).isFalse();
    }

    @Test
    void deposit_shouldNotChangeBalance_whenValueGreaterThanBalance() {
        long accountNumber = 1;

        Account account = Account.builder()
                .number(accountNumber)
                .owner("Owner").build();

        Mockito.when(repository.load(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(account));

        boolean done = accountService.deposit(accountNumber, BigDecimal.TEN.negate());

        assertThat(done).isFalse();
        assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void testWithdraw() {

    }
}
