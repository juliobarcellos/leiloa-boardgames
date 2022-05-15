package br.com.LeiloaBoardgames.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nome;

    private String usuario;

    private String email;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;

    private TipoDocumentoEnum tipoDocumento;

    private String numDocumento;

    private String orgaoExpeditor;

    private EstadoEnum estadoExpeditor;

    private LocalDate dataEmissao;

    @OneToMany
    private List<Jogo> jogosFavoritos = new ArrayList<>();

}
