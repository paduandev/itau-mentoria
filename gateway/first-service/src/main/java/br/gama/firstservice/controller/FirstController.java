package br.gama.firstservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/message")
    public String first() {
        return "Mensagem do FIRST";
    }
}
