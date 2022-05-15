package br.com.LeiloaBoardgames.utils;

import br.com.LeiloaBoardgames.domain.EstadoEnum;
import br.com.LeiloaBoardgames.domain.TipoDocumentoEnum;
import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;

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
                .build();
    }

    public static UsuarioCreateRequest getUsuarioRequestMock() {
        UsuarioCreateRequest usuarioCreateRequest = new UsuarioCreateRequest();
        usuarioCreateRequest.setNome("zé");
        usuarioCreateRequest.setUsuario("seuze");
        usuarioCreateRequest.setEmail("ze@email.com");
        usuarioCreateRequest.setSenha("12345");
        usuarioCreateRequest.setCpf("12345678910");
        usuarioCreateRequest.setDataNascimento(LocalDate.parse("2000-01-01"));
        usuarioCreateRequest.setTelefone("11912345678");
        return usuarioCreateRequest;
    }

    public static UsuarioResponse getUsuarioResponseMock() {
        return UsuarioResponse.builder()
                .id(1)
                .nome("zé")
                .usuario("seuze")
                .email("ze@email.com")
                .senha("12345")
                .cpf("12345678910")
                .dataNascimento(LocalDate.parse("2000-01-01"))
                .telefone("11912345678")
                .build();
    }

}
