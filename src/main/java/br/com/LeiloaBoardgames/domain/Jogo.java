package br.com.LeiloaBoardgames.domain;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idJogo;

    private String Nome;

    private String descricao;

    @OneToMany
    private List<Categoria> categoria;

    private String fichaTecnica;

    private String quantidadeJogadores;

    private String imagemCapa;

    private String complemento;
}
