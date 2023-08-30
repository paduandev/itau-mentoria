package br.gama.hexagonal.application.adapter.rest.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoricRequest {
    long accountNumber;
    LocalDate dateFrom;
    LocalDate dateTo;
}
