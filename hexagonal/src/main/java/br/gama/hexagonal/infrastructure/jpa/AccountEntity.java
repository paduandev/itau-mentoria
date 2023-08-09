package br.gama.hexagonal.infrastructure.jpa;

import java.math.BigDecimal;

import br.gama.hexagonal.domain.model.Account;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    @Column(length = 150, nullable = false)
    private String owner;

    private BigDecimal balance = BigDecimal.ZERO;

    public AccountEntity(Account account) {
        this.number = account.getNumber();
        this.owner = account.getOwner();
        this.balance = account.getBalance();
    }

    public Account toAccount() {
        return new Account(number, owner, balance);
    }
}
