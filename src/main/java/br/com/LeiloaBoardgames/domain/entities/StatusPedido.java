package br.com.LeiloaBoardgames.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusPedido {

    private StatusEnum status;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;
}
