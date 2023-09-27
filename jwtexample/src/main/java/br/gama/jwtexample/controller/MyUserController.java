package br.gama.jwtexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.jwtexample.dto.LoginRequest;
import br.gama.jwtexample.model.MyUser;
import br.gama.jwtexample.service.MyUserService;

@RestController
@RequestMapping("/auth")
public class MyUserController {

    @Autowired
    private MyUserService userService;
    
    @PostMapping("/user")
    public ResponseEntity<MyUser> create(@RequestBody LoginRequest loginRequest) {
        MyUser newUser = userService.createUser(loginRequest.getUsername(), loginRequest.getPassword());
        return  new ResponseEntity<MyUser>(newUser, HttpStatus.CREATED);
    }
}
