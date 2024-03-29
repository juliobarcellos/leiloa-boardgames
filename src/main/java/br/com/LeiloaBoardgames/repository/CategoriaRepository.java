package br.com.LeiloaBoardgames.repository;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNome(String nome);
    List<Categoria> findByIdCategoriaIn(List<Integer> ids);
    Optional<Categoria> findById(Integer id);
    List<Categoria> findAllByAtivoTrue();
    List<Categoria> findByNomeIn(List<String> nomes);
    List<Categoria> findAllByNome(String nome);

}
