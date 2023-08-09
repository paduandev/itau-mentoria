package br.gama.hexagonal.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Builder.Default;

@Getter
@AllArgsConstructor
@Builder
public class Account {
    private long number;
    private String owner;
    @Default
    private BigDecimal balance = BigDecimal.ZERO;

    // saque: 
    // regras: o valor não pode ser negativo e o saldo não pode ficar negativo
    public boolean withdraw(BigDecimal withdrawValue) {
        if(withdrawValue.compareTo(BigDecimal.ZERO) <= 0 || balance.compareTo(withdrawValue) < 0) {
            return false;
        }
        balance = balance.subtract(withdrawValue);
        return true;
    }

    public boolean deposit(BigDecimal depositValue) {
        if(depositValue.compareTo(BigDecimal.ZERO) <= 0) { // valor não pode ser negativo
            return false;
        }
        balance = balance.add(depositValue);
        return true;
    }

    @Override
    public String toString() {
        return "Account [number=" + number + ", owner=" + owner + ", balance=" + balance + "]";
    }

}
