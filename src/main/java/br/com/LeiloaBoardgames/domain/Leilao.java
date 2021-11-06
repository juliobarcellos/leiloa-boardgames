package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Leilao {
    @Id
    private Long id;
    private Long idProduto;
    private String detalheDoItem;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double ValorInicial;
    private Long IdlanceAtual;
    private Long IdlanceVencedor;
    private Long IdVendedor;
    private String lances;
    private Double Altura;
    private Double Largura;
    private Double Comprimento;
    private Double Peso;
    private String Fotos;
}
