package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findUserByDocument(String document); //metodo que busca um usuario pelo documento
    // se coloca o optional pois nao necessariamente vai retornar algo, pode ou nao ter um User com esse Document

    Optional<User> findUserById(Long id); //JPA tem inteligencia para entender o find USER by ID
}
