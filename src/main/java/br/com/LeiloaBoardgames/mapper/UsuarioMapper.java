package br.com.LeiloaBoardgames.mapper;

import br.com.LeiloaBoardgames.domain.entities.EstadoEnum;
import br.com.LeiloaBoardgames.domain.entities.TipoDocumentoEnum;
import br.com.LeiloaBoardgames.domain.entities.Usuario;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "dataNascimento", source = "dataNascimento", qualifiedByName = "stringToDate")
    @Mapping(target = "dataEmissao", source = "dataEmissao", qualifiedByName = "stringToDate")
    @Mapping(target = "tipoDocumento", source = "tipoDocumento", qualifiedByName = "stringToEnumTipoDocumento")
    @Mapping(target = "estadoExpeditor", source = "estadoExpeditor", qualifiedByName = "stringToEstadoEnum")
    Usuario toEntity(UsuarioCreateRequest request);

    UsuarioCreateResponse toCreateResponse(Usuario entity);

    @Mapping(target = "dataNascimento", source = "dataNascimento", qualifiedByName = "stringToDate")
    Usuario toEntity(UsuarioAtualizarRequest request);

    @Mapping(target = "dataNascimento", source = "dataNascimento", qualifiedByName = "dateToString")
    @Mapping(target = "dataEmissao", source = "dataEmissao", qualifiedByName = "dateToString")
    @Mapping(target = "tipoDocumento", source = "tipoDocumento", qualifiedByName = "enumTipoDocumentoToString")
    @Mapping(target = "estadoExpeditor", source = "estadoExpeditor", qualifiedByName = "estadoEnumToString")
    UsuarioResponse toResponse(Usuario entity);

    List<UsuarioResponse> toListResponse(List<Usuario> entity);

    @Named("dateToString")
    public static String dateToString(LocalDate data){
        return data.toString();
    }

    @Named("enumTipoDocumentoToString")
    public static String enumTipoDocumentoToString(TipoDocumentoEnum tipoDocumento){
        return tipoDocumento.toString();
    }

    @Named("estadoEnumToString")
    public static String estadoEnumToString(EstadoEnum estadoExpeditor){
        return estadoExpeditor.toString();
    }

    @Named("stringToDate")
    public static LocalDate stringToDate(String date){
        return LocalDate.parse(date);
    }

    @Named("stringToEnumTipoDocumento")
    public static TipoDocumentoEnum stringToEnumTipoDocumento(String tipoDocumento){
        return TipoDocumentoEnum.valueOf(tipoDocumento);
    }

    @Named("stringToEstadoEnum")
    public static EstadoEnum stringToEstadoEnum(String estado){
        return EstadoEnum.valueOf(estado);
    }

}
