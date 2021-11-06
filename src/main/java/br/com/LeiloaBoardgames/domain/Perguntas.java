package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Perguntas {
    @Id
    private Long id;
    private Long idUsuario;
    private Long idLeilao;
    private String pergunta;
    private String resposta;
    private LocalDateTime dataPergunta;
}