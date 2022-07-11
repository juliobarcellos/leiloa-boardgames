package br.com.LeiloaBoardgames.domain.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLeilao;

    @ManyToOne
    @JoinColumn(name = "idJogo")
    private Jogo jogo;

    private String detalheDoItem;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Double ValorInicial;

    private Long lanceAtual;

    private Long lanceVencedor;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private Usuario vendedor;

    @OneToMany(mappedBy = "leilao")
    @OrderBy("datahora desc")
    private Set<Lance> lances = new HashSet<>();

    private Double Altura;

    private Double Largura;

    private Double Comprimento;

    private Double Peso;

    private String Fotos;
}
