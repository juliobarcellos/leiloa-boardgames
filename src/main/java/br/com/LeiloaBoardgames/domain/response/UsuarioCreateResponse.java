package br.com.LeiloaBoardgames.domain.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreateResponse {

    private String nome;

    private String usuario;

    private String email;
}
