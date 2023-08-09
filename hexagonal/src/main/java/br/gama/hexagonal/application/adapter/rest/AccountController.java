package br.gama.hexagonal.application.adapter.rest;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.hexagonal.application.port.in.AccountOperation;
import br.gama.hexagonal.domain.model.Account;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    
    private final AccountOperation service;

    @PostMapping("/{owner}")
    public ResponseEntity<Account> create(@PathVariable String owner) {
        return ResponseEntity.ok(service.create(owner));
    }

    @PostMapping("/deposito/{id}/{valor}")
    public ResponseEntity<Void> deposit(@PathVariable long id, @PathVariable BigDecimal valor) {
        if(service.deposit(id, valor)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
