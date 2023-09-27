package br.gama.jwtexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.jwtexample.dto.LoginRequest;
import br.gama.jwtexample.dto.LoginResponse;
import br.gama.jwtexample.model.MyUser;
import br.gama.jwtexample.security.JwtService;
import br.gama.jwtexample.service.MyUserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        MyUser user = new MyUser();
        user.setEmail(loginRequest.getUsername());

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok( new LoginResponse(user.getUsername(), token) );
    }

    // @GetMapping("/{token}")
    // public Boolean verify(@PathVariable String token) {
    //     MyUser user = new MyUser(1L, "myuser", "1234", "USER");
    //     return jwtService.isTokenValid(token, user);
    // }
}
