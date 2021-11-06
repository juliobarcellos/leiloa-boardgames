package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.LeiloaBoardgames.domain.Lance;
import br.com.LeiloaBoardgames.repository.LanceRepository;

public class LanceService {
    LanceRepository repository;

    public LanceService(LanceRepository repository) {
        this.repository = repository;
    }

    public void salvar(Lance lance) {
        repository.save(null);
    }

    public void atualizar(Long id, Lance lance) {
        //TODO: mapeamento para atualizar o lance
        Optional<Lance> lanceAtual = repository.findById(id);
        if (lanceAtual.isPresent()) {
            lance = lanceAtual.get();
            repository.save(lance);
        }  
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Lance buscar(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}