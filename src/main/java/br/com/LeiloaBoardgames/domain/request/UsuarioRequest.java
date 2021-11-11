package br.com.LeiloaBoardgames.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {
    private String nome;

    private String usuario;

    private String email;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;
}
