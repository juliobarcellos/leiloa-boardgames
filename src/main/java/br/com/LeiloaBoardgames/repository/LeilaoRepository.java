package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Leilao;

public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

}