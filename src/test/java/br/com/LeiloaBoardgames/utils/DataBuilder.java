package br.com.LeiloaBoardgames.utils;

import br.com.LeiloaBoardgames.domain.EstadoEnum;
import br.com.LeiloaBoardgames.domain.TipoDocumentoEnum;
import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.UsuarioRespose;

import java.time.LocalDate;

public class DataBuilder {

    public static Usuario getUsuarioMock() {
        return Usuario.builder().idUsuario(1)
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento(LocalDate.parse("2000-01-01"))
                .telefone("11912345678")
                .tipoDocumento(TipoDocumentoEnum.RG)
                .numDocumento("123456789")
                .dataEmissao(LocalDate.parse("2000-01-01"))
                .estadoExpeditor(EstadoEnum.getEstado("SP"))
                .orgaoExpeditor("SSP")
                .ativo(true)
                .build();
    }

    public static UsuarioCreateRequest getUsuarioRequestMock() {
        return UsuarioCreateRequest.builder()
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento("2000-01-01")
                .telefone("11912345678")
                .tipoDocumento("RG")
                .numDocumento("123456789")
                .dataEmissao("2000-01-01")
                .estadoExpeditor("SP")
                .orgaoExpeditor("SSP")
                .build();
    }

    public static UsuarioCreateResponse getUsuarioCreateResponseMock() {
        return UsuarioCreateResponse.builder()
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .build();
    }

    public static UsuarioAtualizarRequest getUsuarioAtualizarRequestMock() {
        return UsuarioAtualizarRequest.builder()
                .nome("zé da silva")
                .usuario("seuze")
                .email("zezin@email.com")
                .dataNascimento("1989-01-01")
                .telefone("12912345678")
                .build();
    }

    public static UsuarioRespose getUsuarioResponseMock() {
        return UsuarioRespose.builder()
                .idUsuario(1)
                .nome("zé da silva")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento("2000-01-01")
                .telefone("11912345678")
                .tipoDocumento("RG")
                .numDocumento("123456789")
                .orgaoExpeditor("SSP")
                .estadoExpeditor("SP")
                .dataEmissao("2000-01-01")
                .build();
    }
}
