package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        Usuario usuario = getUsuarioMock();
        when(repository.save(usuario)).thenReturn(usuario);
        Usuario saved = service.save(usuario);

        assertAll(
                () -> assertNotNull(saved),
                () -> assertNotNull(saved.getId()),
                () -> assertEquals(usuario.getNome(), saved.getNome()),
                () -> assertEquals(usuario.getUsuario(), saved.getUsuario()),
                () -> assertEquals(usuario.getEmail(), saved.getEmail()),
                () -> assertEquals(usuario.getSenha(), saved.getSenha()),
                () -> assertEquals(usuario.getCpf(), saved.getCpf()),
                () -> assertEquals(usuario.getDataNascimento(), saved.getDataNascimento()),
                () -> assertEquals(usuario.getTelefone(), saved.getTelefone())
        );
    }

    private Usuario getUsuarioMock() {
        return Usuario.builder().id(1)
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
