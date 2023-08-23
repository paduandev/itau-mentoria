package br.gama.hexagonal.application.adapter.rest.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
    long accountSource;
    long accountTarged;
    BigDecimal value;
}
