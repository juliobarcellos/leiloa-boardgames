package br.com.LeiloaBoardgames.domain.response.categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoriaRespose {
    private Integer idCategoria;
    private String nome;
    private boolean ativo;
}
