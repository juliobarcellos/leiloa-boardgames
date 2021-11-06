package br.com.LeiloaBoardgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LeiloaBoardgames.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
