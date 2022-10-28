package br.com.LeiloaBoardgames.mapper;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.request.categoria.CategoriaRequest;
import br.com.LeiloaBoardgames.domain.response.categoria.CategoriaResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponse toResponse(Categoria entity);

    Categoria toEntity(CategoriaRequest request);

    List<CategoriaResponse> toListResponse(List<Categoria> entity);

}
