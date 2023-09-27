package br.gama.jwtexample.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.gama.jwtexample.model.MyUser;
import br.gama.jwtexample.repository.MyUserRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserService {
    
    private final MyUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Optional<MyUser> getByUserName(String username) {
        return userRepo.findByEmail(username);
    }

    public MyUser createUser(String username, String password) { 
        String encodePassword = passwordEncoder.encode(password);
        MyUser user = new MyUser(null,username, encodePassword ,"USER");

        return userRepo.save(user);
    }
}
