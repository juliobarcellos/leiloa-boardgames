package br.com.LeiloaBoardgames.domain.entities;

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

    private String nome;

    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "jogo_categoria",
            joinColumns = @JoinColumn(name = "id_jogo"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categoria;

    private String fichaTecnica;

    private String quantidadeJogadores;

    private String imagemCapa;

    private String complemento;
}
