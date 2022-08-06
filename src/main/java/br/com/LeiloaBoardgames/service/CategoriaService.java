package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.request.categoria.CategoriaRequest;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public Categoria save(Categoria entity) {

        if (repository.findByNome(entity.getNome()).isEmpty()) {
            return repository.save(entity);
        }
        throw new BusinessException("Categoria já cadastrada");
    }

    public void atualizar(Integer id, CategoriaRequest request) {
        Categoria entity = repository.findById(id).orElseThrow(() -> new BusinessException("Categoria não encontrada"));
        if (repository.findByNome(request.getNome()).isEmpty()) {
            entity.setNome(request.getNome());
            repository.save(entity);
        } else {
            throw new BusinessException("Categoria já cadastrada");
        }
    }

    public List<Categoria> buscarTodos() {
        return repository.findAll();
    }

    public void deletar(Integer id) {
        Categoria entity = repository.findById(id).orElseThrow(() -> new BusinessException("Categoria não encontrada"));
        entity.setAtivo(false);
        repository.save(entity);
    }

    public List<Categoria> buscarTodos(List<Integer> ids){
        return repository.findByIdCategoriaIn(ids);
    }

    public List<Categoria> buscarTodosPorNome(String nome){
        return repository.findAllByNome(nome);
    }

    public List<Categoria> buscarAtivos() {
        return repository.findAllByAtivoTrue();
    }
}
