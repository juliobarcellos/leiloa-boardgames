package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.Perguntas;

@Repository
public interface PerguntasRepository extends JpaRepository<Perguntas, Long> {

}
