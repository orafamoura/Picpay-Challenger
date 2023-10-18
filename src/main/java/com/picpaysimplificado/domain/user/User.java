package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "users") // nao pode ser user, pois e uma palavra reservada dos bancos de dados sql
@Table(name = "users")
@Getter //lombok gera os getters e setter da classe
@Setter
@AllArgsConstructor // lombok gera o construtor com todos os parametros da classe
@EqualsAndHashCode(of = "id") // chave primaria id
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ele gera um valor automatico para o id, criando uma strategy para isso, o IDENTITY gera de forma crescente, id 1 id 2 ... nao e a forma mais segura, de comeco ok
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true) // a coluna e uma chave unica
    private String document;

    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING) // diz que e um dos valores UserType
    private UserType userType;
}
