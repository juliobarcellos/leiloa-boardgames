package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Perguntas {
    private Long id;
    private Long idUsuario;
    private Long idLeilao;
    private String pergunta;
    private String resposta;
    private LocalDateTime dataPergunta;
}