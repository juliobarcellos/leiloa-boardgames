package br.com.LeiloaBoardgames.domain.request.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private String dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Tipo de documento é obrigatório")
    private String tipoDocumento;

    @NotBlank(message = "Numero de documento é obrigatório")
    private String numDocumento;

    @NotBlank(message = "Orgao expedidor é obrigatório")
    private String orgaoExpeditor;

    @NotBlank(message = "Estado é obrigatório")
    private String estadoExpeditor;

    @NotBlank(message = "Data de expedicao é obrigatório")
    private String dataEmissao;
}
