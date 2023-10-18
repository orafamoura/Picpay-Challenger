package com.picpaysimplificado.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repositories.UserRepository;

@Service
public class UserService {

    @Autowired // faz a injecao automatica
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception { //posteriormente implementar tratamento de excecoes
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("User type is not authorized to carry out the transaction");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("User not found enough");
        }
    }
    public User findUserById(Long id) throws Exception { //criamos para o TransactionService nao ter acesso direto ao user repository, ele so vai manipular o transaction repository
       return this.repository.findUserById(id).orElseThrow(() -> new Exception("User no found")); // se nao encontrar o usuario lancamos uma exception
    }

    public void saveUser(User user){ //so para persistir as alteracoes do usuario
        this.repository.save(user);
    }
}