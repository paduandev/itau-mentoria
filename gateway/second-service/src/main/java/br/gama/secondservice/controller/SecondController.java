package br.gama.secondservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {
    
    @Value("${server.port}")
    private int port;

    @GetMapping("/message")
    public String second() {
        return "Mensagem do SECOND: " + port;
    }
}
