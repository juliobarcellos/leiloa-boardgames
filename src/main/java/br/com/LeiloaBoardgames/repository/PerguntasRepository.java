package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Perguntas;

public interface PerguntasRepository extends JpaRepository<Perguntas, Long> {

}
