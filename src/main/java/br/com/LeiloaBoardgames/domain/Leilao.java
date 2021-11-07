package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Integer idProduto;
    private String detalheDoItem;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Double ValorInicial;
    private Integer IdlanceAtual;
    private Integer IdlanceVencedor;
    private Integer IdVendedor;
    private String lances;
    private Double Altura;
    private Double Largura;
    private Double Comprimento;
    private Double Peso;
    private String Fotos;
}
