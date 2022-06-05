package br.com.LeiloaBoardgames.domain.response.jogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogoCreateResponse {

    private Integer idjogo;
    private String Nome;

}
