package br.gama.hexagonal.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    private long accountSourceNumber;
    private long accountTargetNumber;
    private BigDecimal value;
    private LocalDateTime dateTime;

}
