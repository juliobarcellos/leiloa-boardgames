package br.com.LeiloaBoardgames.mapper;

import br.com.LeiloaBoardgames.domain.entities.Leilao;
import br.com.LeiloaBoardgames.domain.request.leilao.LeilaoCreateRequest;
import br.com.LeiloaBoardgames.domain.response.leilao.LeilaoCreateResponse;
import br.com.LeiloaBoardgames.domain.response.leilao.LeilaoResponse;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LeilaoMapper {
    Leilao toEntity(LeilaoCreateRequest request);

    LeilaoCreateResponse toCreateResponse(Leilao entity);

    LeilaoResponse toResponse(Leilao entity);

    List<LeilaoResponse> toListResponse(List<Leilao> entity);
}
