package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByUsuario(String usuario);
    Optional<Usuario> findByEmailIgnoreCase(String email);
    Optional<Usuario> findByCpfIgnoreCase(String cpf);
    Optional<Usuario> findByUsuarioIgnoreCase(String usuario);
    List<Usuario> findAllByAtivo(boolean ativo);
}
