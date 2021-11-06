package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.Produto;
import br.com.LeiloaBoardgames.repository.ProdutoRepository;

@Service
public class ProdutoService {
    ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Produto produto) {
        repository.save(null);
    }

    public void atualizar(Long id, Produto produto) {
        //TODO: mapeamento para atualizar o produto
        Optional<Produto> produtoAtual = repository.findById(id);
        if (produtoAtual.isPresent()) {
            produto = produtoAtual.get();
            repository.save(produto);
        }  
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Produto buscar(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
