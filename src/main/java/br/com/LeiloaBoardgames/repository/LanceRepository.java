package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Lance;

public interface LanceRepository extends JpaRepository<Lance, Long> {

}
