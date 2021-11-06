package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.Leilao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}