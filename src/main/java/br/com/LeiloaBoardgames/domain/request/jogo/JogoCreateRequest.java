package br.com.LeiloaBoardgames.domain.request.jogo;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JogoCreateRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Integer categoria;
    @NotBlank
    private String fichaTecnica;
    @NotBlank
    private String quantidadeJogadores;
    @NotBlank
    private String imagemCapa;
    @NotBlank
    private String complemento;
}
