package br.com.LeiloaBoardgames.domain.response.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsuarioRespose {

    private Integer idUsuario;
    private String nome;

    private String usuario;

    private String email;

    private String senha;

    private String cpf;

    private String dataNascimento;

    private String telefone;

    private String tipoDocumento;

    private String numDocumento;

    private String orgaoExpeditor;

    private String estadoExpeditor;

    private String dataEmissao;

    private Boolean ativo;
}
