package br.gama.hexagonal.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transfer {
    private long accountSourceNumber;
    private long accountTargetNumber;
    private BigDecimal value;
    private LocalDate dateTime;

}
