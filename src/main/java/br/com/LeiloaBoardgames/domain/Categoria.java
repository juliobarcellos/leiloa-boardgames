package br.com.LeiloaBoardgames.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categoria {
    @Id
    private Long id;
    private String nome;
}
