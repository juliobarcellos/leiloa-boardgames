package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.entities.Lance;
import br.com.LeiloaBoardgames.repository.LanceRepository;

@Service
public class LanceService {
    LanceRepository repository;

    public LanceService(LanceRepository repository) {
        this.repository = repository;
    }

    public void salvar(Lance lance) {
        repository.save(null);
    }

    public void atualizar(Integer id, Lance lance) {
        // TODO: mapeamento para atualizar o lance
        Optional<Lance> lanceAtual = repository.findById(id);
        if (lanceAtual.isPresent()) {
            lance = lanceAtual.get();
            repository.save(lance);
        }
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Lance buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
