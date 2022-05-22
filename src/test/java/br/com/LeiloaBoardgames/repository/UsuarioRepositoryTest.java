package br.com.LeiloaBoardgames.repository;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.utils.DataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve salvar um usuario")
    public void deveSalvarUsuario() {
        Usuario usuario = DataBuilder.getUsuarioAtivoMock();
        usuario.setIdUsuario(null);
        usuarioRepository.save(usuario);
        assertThat(usuario.getIdUsuario()).isNotNull();
    }


    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um usuário com o email informado")
    public void deveRetornarVerdadeiroQuandoExistirUmUsuarioComEmailInformado() {
        Usuario usuario = Usuario.builder().email("test@teste.com").build();
        entityManager.persist(usuario);
        entityManager.flush();
        
        boolean result = usuarioRepository.existsByEmail(usuario.getEmail());
        
        assertThat(result).isTrue();
    }
    
    @Test
    @DisplayName("Deve retornar falso quando não existir um usuário com o email informado")
    public void deveRetornarFalsoQuandoNaoExistirUmUsuarioComEmailInformado() {
        boolean result = usuarioRepository.existsByEmail("teste@teste.com");
        
        assertThat(result).isFalse();
    }
    
    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um usuario com o cpf informado")
    public void deveRetornarVerdadeiroQuandoExistirUmUsuarioComCpfInformado() {
        Usuario usuario = Usuario.builder().cpf("12345678901").build();
        entityManager.persist(usuario);
        entityManager.flush();
        
        boolean result = usuarioRepository.existsByCpf(usuario.getCpf());
        
        assertThat(result).isTrue();
    }
    
    @Test
    @DisplayName("Deve retornar falso quando não existir um usuário com o cpf informado")
    public void deveRetornarFalsoQuandoNaoExistirUmUsuarioComCpfInformado() {
        boolean result = usuarioRepository.existsByCpf("12345678901");
        
        assertThat(result).isFalse();
    }
    
    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um usuário com o usuario informado")
    public void deveRetornarVerdadeiroQuandoExistirUmUsuarioComUsuarioInformado() {
        Usuario usuario = Usuario.builder().usuario("teste").build();
        entityManager.persist(usuario);
        entityManager.flush();
        
        boolean result = usuarioRepository.existsByUsuario(usuario.getUsuario());
        
        assertThat(result).isTrue();
    }
    
    @Test
    @DisplayName("Deve retornar falso quando não existir um usuário com o usuario informado")
    public void deveRetornarFalsoQuandoNaoExistirUmUsuarioComUsuarioInformado() {
        boolean result = usuarioRepository.existsByUsuario("teste");
        
        assertThat(result).isFalse();
    }
}

