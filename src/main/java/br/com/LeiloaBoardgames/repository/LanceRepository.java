package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LeiloaBoardgames.domain.entities.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {

}
