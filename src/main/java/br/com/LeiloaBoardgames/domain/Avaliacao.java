package br.com.LeiloaBoardgames.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAvaliacao;

    private Long idLeilao;

    private Boolean status;

    private String descricao;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
