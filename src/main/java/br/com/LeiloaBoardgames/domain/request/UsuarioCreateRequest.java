package br.com.LeiloaBoardgames.domain.request;

import br.com.LeiloaBoardgames.domain.EstadoEnum;
import br.com.LeiloaBoardgames.domain.TipoDocumentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Tipo de documento é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private TipoDocumentoEnum tipoDocumento;

    @NotBlank(message = "Numero de documento é obrigatório")
    private String numDocumento;

    @NotBlank(message = "Orgao expedidor é obrigatório")
    private String orgaoExpeditor;

    @NotBlank(message = "Estado é obrigatório")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EstadoEnum estado;

    @NotBlank(message = "Data de expedicao é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmissao;
}
