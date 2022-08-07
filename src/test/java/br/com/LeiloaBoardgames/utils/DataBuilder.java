package br.com.LeiloaBoardgames.utils;

import br.com.LeiloaBoardgames.domain.entities.*;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoCreateRequest;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoCreateResponse;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoRespose;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioRespose;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataBuilder {

    public static Usuario getUsuarioAtivoMock() {
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

    public static Usuario getUsuarioInativoMock() {
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
                .ativo(false)
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

    public static Jogo jogoMock() {
        return Jogo.builder()
                .idJogo(1)
                .nome("Jogo de teste")
                .descricao("Jogo de teste")
                .categoria(categoriaMock())
                .fichaTecnica("Jogo de teste")
                .quantidadeJogadores("10")
                .imagemCapa("Jogo de teste")
                .complemento("Jogo de teste")
                .build();
    }

    public static JogoCreateRequest jogoCreateRequestMock() {

        return JogoCreateRequest.builder()
                .nome("Jogo de teste")
                .descricao("Jogo de teste")
                .categoria(1)
                .fichaTecnica("Jogo de teste")
                .quantidadeJogadores("10")
                .imagemCapa("Jogo de teste")
                .complemento("Jogo de teste")
                .build();
    }

    public static JogoRespose jogoResponseMock() {
        return JogoRespose.builder()
                .idJogo(1)
                .nome("Jogo de teste")
                .descricao("Jogo de teste")
                .categoria(categoriaMock())
                .fichaTecnica("Jogo de teste")
                .quantidadeJogadores("10")
                .imagemCapa("Jogo de teste")
                .complemento("Jogo de teste")
                .build();
    }

    public static JogoAtualizarRequest jogoAtualizarRequestMock() {
        return JogoAtualizarRequest.builder()
                .nome("Jogo de teste")
                .descricao("Jogo de teste")
                .categoria(categoriaMock())
                .fichaTecnica("Jogo de teste")
                .quantidadeJogadores("10")
                .imagemCapa("Jogo de teste")
                .complemento("Jogo de teste")
                .build();
    }

    public static Categoria categoriaMock() {
        return Categoria.builder()
                .idCategoria(1)
                .nome("Categoria de teste")
                .build();
    }

    public static JogoCreateResponse jogoCreateResponseMock() {
        return JogoCreateResponse.builder()
                .idjogo(1)
                .nome("Jogo de teste")
                .build();
    }
}
