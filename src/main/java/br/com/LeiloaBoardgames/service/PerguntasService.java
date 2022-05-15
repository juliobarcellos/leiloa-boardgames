package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.Pergunta;
import br.com.LeiloaBoardgames.repository.PerguntasRepository;

@Service
public class PerguntasService {
    PerguntasRepository repository;

    public PerguntasService(PerguntasRepository repository) {
        this.repository = repository;
    }

    public void salvar(Pergunta pergunta) {
        repository.save(null);
    }

    public void atualizar(Integer id, Pergunta pergunta) {
        // TODO: mapeamento para atualizar o perguntas
        Optional<Pergunta> perguntasAtual = repository.findById(id);
        if (perguntasAtual.isPresent()) {
            pergunta = perguntasAtual.get();
            repository.save(pergunta);
        }
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Pergunta buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
