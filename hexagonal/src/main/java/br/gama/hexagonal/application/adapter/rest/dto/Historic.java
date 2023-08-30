package br.gama.hexagonal.application.adapter.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Historic {
    BigDecimal value;
    String date;
}