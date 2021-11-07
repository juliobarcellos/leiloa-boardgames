package br.com.LeiloaBoardgames.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Nome;

    private String descrição;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    private String fichaTecnica;

    private String quantidadeJogadores;

    private String imagemCapa;
}
