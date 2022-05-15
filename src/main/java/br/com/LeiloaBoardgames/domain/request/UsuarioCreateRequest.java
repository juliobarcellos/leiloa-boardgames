package br.com.LeiloaBoardgames.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioCreateRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Usuario é obrigatório")
    private String usuario;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @NotBlank(message = "Cpf é obrigatório")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatório")
    @Past
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}
