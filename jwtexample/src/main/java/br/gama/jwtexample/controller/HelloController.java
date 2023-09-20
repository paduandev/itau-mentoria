package br.gama.jwtexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/free")
    public String free() {
        return "Acesso livre";
    }

    @GetMapping("/auth")
    public String auth() {
        return "Acesso Autenticado";
    }

    @GetMapping("/secret")
    public String secret() {
        return "Acesso Secreto";
    }
}
