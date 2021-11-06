package br.com.LeiloaBoardgames.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {
    @Id
    private Long id;
    private String Nome;
    private String descrição;
    private String categoria;
    private String fichaTecnica;
    private String quantidadeJogadores;
    private String imagemCapa;
}
