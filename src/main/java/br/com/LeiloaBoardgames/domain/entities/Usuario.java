package br.com.LeiloaBoardgames.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueUsuarioAtivo", columnNames = {"usuario", "ativo"}),
        @UniqueConstraint(name = "UniqueEmailAtivo", columnNames = {"email", "ativo"}),
        @UniqueConstraint(name = "UniqueCpfAtivo", columnNames = {"cpf", "ativo"})
})
@JsonIdentityReference
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("idUsuario")
    private Integer idUsuario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("tipoDocumento")
    private TipoDocumentoEnum tipoDocumento;

    @JsonProperty("numDocumento")
    private String numDocumento;

    @JsonProperty("orgaoExpeditor")
    private String orgaoExpeditor;

    @JsonProperty("estadoExpeditor")
    private EstadoEnum estadoExpeditor;

    @JsonProperty("dataEmissao")
    private LocalDate dataEmissao;

    @JsonProperty("ativo")
    private Boolean ativo;

    @OneToMany
    private List<Jogo> jogosFavoritos = new ArrayList<>();


}
