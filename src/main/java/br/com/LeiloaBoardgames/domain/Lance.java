package br.com.LeiloaBoardgames.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLance;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "idLeilao")
    private Leilao leilao;

    private Double valor;

    private LocalDateTime datahora = LocalDateTime.now();
}
