package br.com.LeiloaBoardgames.domain.entities;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategoria;

    private String nome;

    @Builder.Default
    private boolean ativo = true;
}
