package br.com.LeiloaBoardgames.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private Long id;
    private String destinatario;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Boolean preferencial;
}
