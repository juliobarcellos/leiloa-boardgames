package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import br.com.LeiloaBoardgames.utils.DataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService service;
    @Mock
    private UsuarioRepository repository;

    @Test
    @DisplayName("Deve salvar um usuário")
    public void createUser() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.existsByCpf(anyString())).thenReturn(false);
        when(repository.existsByEmail(anyString())).thenReturn(false);
        when(repository.existsByUsuario(anyString())).thenReturn(false);
        Usuario saved = service.save(usuario);

        assertAll(
                () -> assertNotNull(saved),
                () -> assertNotNull(saved.getIdUsuario()),
                () -> assertEquals(usuario.getNome(), saved.getNome()),
                () -> assertEquals(usuario.getUsuario(), saved.getUsuario()),
                () -> assertEquals(usuario.getEmail(), saved.getEmail()),
                () -> assertEquals(usuario.getSenha(), saved.getSenha()),
                () -> assertEquals(usuario.getCpf(), saved.getCpf()),
                () -> assertEquals(usuario.getDataNascimento(), saved.getDataNascimento()),
                () -> assertEquals(usuario.getTelefone(), saved.getTelefone())
        );
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar um usuário com CPF já cadastrado")
    public void createUserCpfException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.existsByCpf(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.save(usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("CPF já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar um usuário com email já cadastrado")
    public void createUserEmailException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.existsByEmail(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.save(usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("Email já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar um usuário com usuário já cadastrado")
    public void createUserUsuarioException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.existsByUsuario(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.save(usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("Usuário já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve atualizar um usuário")
    public void updateUser() throws NoSuchElementException {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));

        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.existsByCpf(anyString())).thenReturn(false);
        when(repository.existsByEmail(anyString())).thenReturn(false);
        when(repository.existsByUsuario(anyString())).thenReturn(false);
        Usuario saved = service.atualizar(1, usuario);

        assertAll(
                () -> assertNotNull(saved),
                () -> assertNotNull(saved.getIdUsuario()),
                () -> assertEquals(usuario.getNome(), saved.getNome()),
                () -> assertEquals(usuario.getUsuario(), saved.getUsuario()),
                () -> assertEquals(usuario.getEmail(), saved.getEmail()),
                () -> assertEquals(usuario.getSenha(), saved.getSenha()),
                () -> assertEquals(usuario.getCpf(), saved.getCpf()),
                () -> assertEquals(usuario.getDataNascimento(), saved.getDataNascimento()),
                () -> assertEquals(usuario.getTelefone(), saved.getTelefone())
        );
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar um usuário com CPF já cadastrado")
    public void updateUserCpfException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.existsByCpf(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.atualizar(1, usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("CPF já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar um usuário com email já cadastrado")
    public void updateUserEmailException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.existsByEmail(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.atualizar(1, usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("Email já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar um usuário com usuário já cadastrado")
    public void updateUserUsuarioException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.existsByUsuario(anyString())).thenReturn(true);
        Throwable exception = catchThrowable(() -> service.atualizar(1, usuario));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("Usuário já cadastrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve laçar exceção ao atualizar um usuário inexistente")
    public void updateUserNoSuchElementException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        Throwable exception = catchThrowable(() -> service.atualizar(1, usuario));
        assertThat(exception).isInstanceOf(NoSuchElementException.class).hasMessage("Usuário não encontrado");
        verify(repository, never()).save(usuario);
    }

    @Test
    @DisplayName("Deve deletar um usuário")
    public void deleteUser() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        service.deletar(1);
        verify(repository).delete(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao deletar um usuário inexistente")
    public void deleteUserNoSuchElementException() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        Throwable exception = catchThrowable(() -> service.deletar(1));
        assertThat(exception).isInstanceOf(NoSuchElementException.class).hasMessage("Usuário não encontrado");
        verify(repository, never()).delete(any());
    }

    @Test
    @DisplayName("Deve lançar exceção ao deletar um usuário já deletado")
    public void deleteUserAlreadyDeletedException() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        usuario.setAtivo(false);
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        when(repository.existsById(anyInt())).thenReturn(false);
        Throwable exception = catchThrowable(() -> service.deletar(1));
        assertThat(exception).isInstanceOf(BusinessException.class).hasMessage("Usuário já deletado");
        verify(repository, never()).delete(usuario);
    }

    @Test
    @DisplayName("Deve buscar um usuário pelo seu id")
    public void findUserById() {
        Usuario usuario = DataBuilder.getUsuarioMock();
        when(repository.findById(anyInt())).thenReturn(Optional.of(usuario));
        assertThat(service.buscarPorId(1)).isEqualTo(usuario);
    }

    @Test
    @DisplayName("Deve lançar exceção ao buscar um usuário inexistente")
    public void findUserNoSuchElementException() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        Throwable exception = catchThrowable(() -> service.buscarPorId(1));
        assertThat(exception).isInstanceOf(NoSuchElementException.class).hasMessage("Usuário não encontrado");
    }

    @Test
    @DisplayName("Deve retornar todos os usuários")
    public void findAllUsers() {
        List<Usuario> usuarios = List.of(DataBuilder.getUsuarioMock());
        when(repository.findAll()).thenReturn(usuarios);
        assertThat(service.buscarTodos()).isEqualTo(usuarios);
    }

    @Test
    @DisplayName("Deve retornar vazio ao buscar todos os usuários")
    public void findAllUsersEmpty() {
        when(repository.findAll()).thenReturn(List.of());
        assertThat(service.buscarTodos()).isEmpty();
    }

}
