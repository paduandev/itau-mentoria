package br.gama.jwtexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gama.jwtexample.model.MyUser;

public interface MyUserRepo extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String email);
}
