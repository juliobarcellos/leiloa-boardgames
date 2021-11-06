package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
