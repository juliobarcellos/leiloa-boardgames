package br.com.LeiloaBoardgames.domain;

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
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;

    private String identificacao;
    
    private String destinatario;
    
    private String cep;
    
    private String logradouro;
    
    private String numero;
    
    private String complemento;
    
    private String bairro;
    
    private String cidade;
    
    private EstadoEnum estado;
    
    private Boolean preferencial;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
