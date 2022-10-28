package br.com.LeiloaBoardgames.domain.response.leilao;

import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.entities.Lance;
import br.com.LeiloaBoardgames.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeilaoCreateResponse {
    private Integer idLeilao;
    private Jogo jogo;
    private String detalheDoItem;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double valorInicial;
    private Double incremento;
    private Usuario vendedor;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double peso;
    private String fotos;
}
