package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoAtualizarRequest;
import br.com.LeiloaBoardgames.repository.JogoRepository;
import br.com.LeiloaBoardgames.utils.DataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class JogoServiceTest {

    @InjectMocks
    private JogoService service;
    @Mock
    private JogoRepository repository;

    @Test
    @DisplayName("Deve salvar um jogo")
    void salvarTeste(){
        Jogo jogoMock = DataBuilder.jogoMock();
        when(repository.existsByNome(anyString())).thenReturn(false);
        when(repository.save(jogoMock)).thenReturn(jogoMock);
        assertNotNull(service.save(jogoMock));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar salvar um jogo com nome duplicado")
    void salvarJogoDuplicadoTeste(){
        Jogo jogoMock = DataBuilder.jogoMock();
        when(repository.existsByNome(anyString())).thenReturn(true);
        assertThrows(RuntimeException.class, () -> service.save(jogoMock));
    }

    @Test
    @DisplayName("Deve atualizar o nome de um jogo")
    void atualizarTeste(){
        Jogo jogoMock = DataBuilder.jogoMock();
        JogoAtualizarRequest jogoAtualizar = JogoAtualizarRequest.builder().nome("Nome atualizado").build();
        Jogo jogoAtualizado = jogoMock;
        jogoAtualizado.setNome(jogoAtualizar.getNome());
        when(repository.findById(anyInt())).thenReturn(Optional.of(jogoMock));
        when(repository.save(jogoMock)).thenReturn(jogoAtualizado);
        assertNotNull(service.atualizar(1, jogoAtualizar));
    }

    @Test
    @DisplayName("Deve atualizar a categoria de um Jogo")
    void atualizarCategoriaTeste(){
        Jogo jogoMock = DataBuilder.jogoMock();
        List<Categoria> categorias = Arrays.asList(DataBuilder.categoriaMock(),
                Categoria.builder().idCategoria(2).nome("outra Categoria").build(),
                Categoria.builder().idCategoria(2).nome("outra Categoria").build());
        JogoAtualizarRequest jogoAtualizar = JogoAtualizarRequest.builder().categoria(categorias).build();
        Jogo jogoAtualizado = DataBuilder.jogoMock();
        jogoAtualizado.setCategoria(jogoAtualizar.getCategoria());
        when(repository.findById(anyInt())).thenReturn(Optional.of(jogoMock));
        when(repository.save(jogoMock)).thenReturn(jogoAtualizado);
        assertNotNull(service.atualizar(1, jogoAtualizar));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar atualizar um jogo inexistente")
    void atualizarJogoInexistenteTeste(){
        JogoAtualizarRequest jogoAtualizar = JogoAtualizarRequest.builder().nome("Nome atualizado").build();
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.atualizar(1, jogoAtualizar));
    }

    @Test
    @DisplayName("Deve deletar um jogo")
    void deletarTeste(){
        Jogo jogoMock = DataBuilder.jogoMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(jogoMock));
        service.deletar(1);
        verify(repository).delete(jogoMock);
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar deletar um jogo inexistente")
    void deletarJogoInexistenteTeste(){
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.deletar(1));
    }

    @Test
    @DisplayName("Deve retornar uma lista de jogos")
    void listarTeste(){
        List<Jogo> jogos = List.of(DataBuilder.jogoMock());
        when(repository.findAll()).thenReturn(jogos);
        assertEquals(jogos, service.buscarTodos());
    }

    @Test
    @DisplayName("Deve retornar uma lista de jogos com filtro")
    void listarFiltroTeste(){
        List<Jogo> jogos = List.of(DataBuilder.jogoMock());
        when(repository.findByNomeContainingIgnoreCase(anyString())).thenReturn(Optional.of(jogos));
        assertEquals(jogos, service.buscarPorNome("nome"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar buscar um jogo inexistente")
    void listarJogoInexistenteTeste(){
        when(repository.findByNomeContainingIgnoreCase(anyString())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.buscarPorNome("nome"));
    }

    @Test
    @DisplayName("Deve retornar uma lista de jogos com filtro de categoria")
    void listarPorCategoriaTeste(){
        List<Jogo> jogos = List.of(DataBuilder.jogoMock());
        when(repository.findByCategoriaContainingIgnoreCase(any())).thenReturn(Optional.of(jogos));
        assertEquals(jogos, service.buscarPorCategoria("Categoria de teste"));
    }
    //TODO: acho que terminou esse teste, testar o controler
}