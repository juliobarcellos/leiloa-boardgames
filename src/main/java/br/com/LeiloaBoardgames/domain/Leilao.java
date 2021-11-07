package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private String detalheDoItem;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Double ValorInicial;

    //TODO: Verificar se é necessário ou não o lance atual e o lance vencedor
    //da pra usar apenas a lista de lances e pegar o ultimo lance para os dois casos;
    @OneToOne(mappedBy = "leilao")
    private Lance lanceAtual;

    @OneToOne(mappedBy = "leilao")
    private Lance lanceVencedor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")

    private Usuario vendedor;

    @OneToMany(mappedBy = "leilao")
    @OrderBy("dataHora DESC")
    private Set<Lance> lances;

    private Double Altura;

    private Double Largura;

    private Double Comprimento;

    private Double Peso;

    private String Fotos;
}
