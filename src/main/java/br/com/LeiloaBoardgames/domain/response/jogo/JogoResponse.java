package br.com.LeiloaBoardgames.domain.response.jogo;

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
public class JogoResponse {

    private Integer idJogo;
    private String nome;
    private String descricao;
    private List<Categoria> categoria;
    private String fichaTecnica;
    private String quantidadeJogadores;
    private String imagemCapa;
    private String complemento;
}
