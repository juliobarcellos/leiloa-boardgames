package br.com.LeiloaBoardgames.mapper;

import br.com.LeiloaBoardgames.domain.EstadoEnum;
import br.com.LeiloaBoardgames.domain.TipoDocumentoEnum;
import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.UsuarioRespose;
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
    UsuarioRespose toResponse(Usuario entity);

    List<UsuarioRespose> toListResponse(List<Usuario> entity);

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
