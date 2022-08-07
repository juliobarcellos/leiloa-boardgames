package br.com.LeiloaBoardgames.domain.request.jogo;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JogoAtualizarRequest {

    private String nome;
    private String descricao;
    private String categoria;
    private String fichaTecnica;
    private String quantidadeJogadores;
    private String imagemCapa;
    private String complemento;
}
