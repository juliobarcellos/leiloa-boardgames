package br.com.LeiloaBoardgames.repository;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoFiltro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.entities.Jogo;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    Boolean existsByNome(String nome);

    Optional<List<Jogo>> findByNomeContainingIgnoreCase(String nome);

    Optional<List<Jogo>> findByCategoriaContainingIgnoreCase(String categoria);

    Optional<List<Jogo>> findByCategoriaIsIn(List<Categoria> categoria);
}
