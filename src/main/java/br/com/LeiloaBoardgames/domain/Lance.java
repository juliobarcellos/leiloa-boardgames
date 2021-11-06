package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lance {
    private Long id;
    private Long idUsuario;
    private Long idLeilao;
    private Double valor;
    private LocalDateTime datahora;
}
