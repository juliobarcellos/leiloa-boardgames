package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.Jogo;
import br.com.LeiloaBoardgames.repository.ProdutoRepository;

@Service
public class ProdutoService {
    ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Jogo jogo) {
        repository.save(null);
    }

    public void atualizar(Integer id, Jogo jogo) {
        // TODO: mapeamento para atualizar o produto
        Optional<Jogo> produtoAtual = repository.findById(id);
        if (produtoAtual.isPresent()) {
            jogo = produtoAtual.get();
            repository.save(jogo);
        }
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Jogo buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
