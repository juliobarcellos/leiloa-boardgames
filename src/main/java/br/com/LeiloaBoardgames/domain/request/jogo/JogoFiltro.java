package br.com.LeiloaBoardgames.domain.request.jogo;

import br.com.LeiloaBoardgames.domain.entities.Categoria;

import java.util.List;

public class JogoFiltro {
    private String nome;
    private List<Categoria> categoria;
    private String quantidadeJogadoresMin;
    private String quantidadeJogadoresMax;
}
