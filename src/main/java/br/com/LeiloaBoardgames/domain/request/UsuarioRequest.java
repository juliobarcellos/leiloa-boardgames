package br.com.LeiloaBoardgames.domain.request;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
=======
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

>>>>>>> e7e4d7d (refact - merge master)
import java.time.LocalDate;

@Getter
@Setter
<<<<<<< HEAD
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
=======
public class UsuarioRequest {
    private String nome;

    private String usuario;

    private String email;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

>>>>>>> e7e4d7d (refact - merge master)
    private String telefone;
}
