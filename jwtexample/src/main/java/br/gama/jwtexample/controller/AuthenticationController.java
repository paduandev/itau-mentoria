package br.gama.jwtexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.jwtexample.dto.LoginRequest;
import br.gama.jwtexample.dto.LoginResponse;
import br.gama.jwtexample.security.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {

        // MyUser user = new MyUser();
        // user.setEmail(loginRequest.getUsername());

        // String token = jwtService.generateToken(user);

        // return ResponseEntity.ok( new LoginResponse(user.getUsername(), token) );

        return ResponseEntity.ok(authenticationService.authentication(loginRequest));

    }


}
