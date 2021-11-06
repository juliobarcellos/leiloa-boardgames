package br.com.LeiloaBoardgames.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Long id;
    private String nome;
    private String usuário;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
}
