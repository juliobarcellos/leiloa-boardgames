package br.com.LeiloaBoardgames.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private Long id;
    private String Nome;
    private String descrição;
    private String categoria;
    private String fichaTecnica;
    private String quantidadeJogadores;
    private String imagemCapa;
}
