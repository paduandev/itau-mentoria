package br.gama.hexagonal.infrastructure.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    private long accountSourceNumber;
    private long accountTargetNumber;
    private BigDecimal value;
    private LocalDate dateTime;
}
