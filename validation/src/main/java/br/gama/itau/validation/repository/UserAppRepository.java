package br.gama.itau.validation.repository;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.validation.model.UserApp;

public interface UserAppRepository extends CrudRepository<UserApp, Long> {
    
}
