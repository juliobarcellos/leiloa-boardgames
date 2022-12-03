package br.com.LeiloaBoardgames.domain.request.leilao;

import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LeilaoCreateRequest {
    @NotNull
    private Jogo jogo;
    @NotBlank
    private String detalheDoItem;
    @NotNull
    private LocalDateTime dataFim;
    @NotNull
    private Double valorInicial;
    @NotNull
    private Double incremento;
    @NotNull
    private Usuario vendedor;
    @NotNull
    private Double altura;
    @NotNull
    private Double largura;
    @NotNull
    private Double comprimento;
    @NotNull
    private Double peso;
    @NotBlank
    private String fotos;
}
