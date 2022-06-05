package br.com.LeiloaBoardgames.domain.entities;

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
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCartao;

    private String nomeTitular;

    private String numCartao;

    private Integer mesExpiracao;

    private Integer anoExpiracao;

    private Integer cvv;

    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
