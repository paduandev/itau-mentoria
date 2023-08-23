package br.gama.hexagonal.infrastructure.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.gama.hexagonal.domain.model.Transfer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    private long accountSourceNumber;
    private long accountTargetNumber;
    private BigDecimal value;
    private LocalDate dateTime;

    public Transfer toTransfer() {
        return Transfer.builder()
        .accountSourceNumber(accountSourceNumber)
        .accountTargetNumber(accountTargetNumber)
        .value(value)
        .dateTime(dateTime)
        .build();
    }
}
