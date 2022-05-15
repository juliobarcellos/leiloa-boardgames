package br.com.LeiloaBoardgames.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    private String numBanco;

    private String agencia;

    private String contaCorrente;

    private Character digito;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
