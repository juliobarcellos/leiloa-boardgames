package br.com.LeiloaBoardgames.domain.response;

import lombok.*;

import java.time.LocalDate;

<<<<<<< HEAD
@Data
=======
@Getter
@Setter
>>>>>>> e7e4d7d (refact - merge master)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private Integer id;

    private String nome;

    private String usuario;

    private String email;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;
}
