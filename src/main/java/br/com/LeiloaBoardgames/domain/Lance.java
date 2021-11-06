package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lance {
    @Id
    Long id;
    private Long idUsuario;
    private Long idLeilao;
    private Double valor;
    private LocalDateTime datahora;
}
