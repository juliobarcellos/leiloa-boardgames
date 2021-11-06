package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.LeiloaBoardgames.domain.Perguntas;
import br.com.LeiloaBoardgames.repository.PerguntasRepository;

public class PerguntasService {
    PerguntasRepository repository;

    public PerguntasService(PerguntasRepository repository) {
        this.repository = repository;
    }

    public void salvar(Perguntas perguntas) {
        repository.save(null);
    }

    public void atualizar(Long id, Perguntas perguntas) {
        //TODO: mapeamento para atualizar o perguntas
        Optional<Perguntas> perguntasAtual = repository.findById(id);
        if (perguntasAtual.isPresent()) {
            perguntas = perguntasAtual.get();
            repository.save(perguntas);
        }  
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Perguntas buscar(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
