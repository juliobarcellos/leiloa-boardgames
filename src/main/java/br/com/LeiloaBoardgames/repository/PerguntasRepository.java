package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.Pergunta;

@Repository
public interface PerguntasRepository extends JpaRepository<Pergunta, Integer> {

}
