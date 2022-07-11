package br.com.LeiloaBoardgames.mapper;

import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoCreateRequest;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoRespose;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JogoMapper {
    @Mapping(target = "categoria", ignore = true)
    Jogo toEntity(JogoCreateRequest request);

    JogoRespose toResponse(Jogo entity);

    List<JogoRespose> toListResponse(List<Jogo> entity);

//    @Mapping(target = "dataNascimento", source = "dataNascimento", qualifiedByName = "stringToDate")
//    @Mapping(target = "dataEmissao", source = "dataEmissao", qualifiedByName = "stringToDate")
//    @Mapping(target = "tipoDocumento", source = "tipoDocumento", qualifiedByName = "stringToEnumTipoDocumento")
//    @Mapping(target = "estadoExpeditor", source = "estadoExpeditor", qualifiedByName = "stringToEstadoEnum")
//    Jogo toEntity(JogoCreateRequest request);
//
//    @Named("enumTipoDocumentoToString")
//    public static String enumTipoDocumentoToString(TipoDocumentoEnum tipoDocumento){
//        return tipoDocumento.toString();



}
