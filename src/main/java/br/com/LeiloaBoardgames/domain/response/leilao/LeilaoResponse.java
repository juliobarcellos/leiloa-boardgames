package br.com.LeiloaBoardgames.domain.response.leilao;

import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.entities.Lance;
import br.com.LeiloaBoardgames.domain.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LeilaoResponse {
    private Integer idLeilao;
    private Jogo jogo;
    private String detalheDoItem;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double valorInicial;
    private Double incremento;
    private Integer lanceAtual;
    private Integer lanceVencedor;
    private Usuario vendedor;
    private Set<Lance> lances = new HashSet<>();
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double peso;
    private String fotos;
}
