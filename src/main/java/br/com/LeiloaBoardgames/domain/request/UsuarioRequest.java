package br.com.LeiloaBoardgames.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String usuario;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String telefone;
}
