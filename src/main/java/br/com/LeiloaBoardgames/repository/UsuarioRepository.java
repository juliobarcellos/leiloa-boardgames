package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
