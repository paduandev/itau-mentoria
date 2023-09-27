package br.gama.jwtexample.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gama.jwtexample.dto.LoginRequest;
import br.gama.jwtexample.dto.LoginResponse;
import br.gama.jwtexample.model.MyUser;
import br.gama.jwtexample.service.MyUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final MyUserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponse authentication(LoginRequest loginRequest) {
        MyUser myUser = userService.getByUserName(loginRequest.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("Usuário ou senha inválido"));

        // verifica por meio do Authentication Manager se o username e password são validos 
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername(), loginRequest.getPassword()));

        String token = jwtService.generateToken(myUser);

        return new LoginResponse(myUser.getUsername(), token);
    }
}
