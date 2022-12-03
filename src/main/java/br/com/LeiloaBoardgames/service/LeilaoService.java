package br.com.LeiloaBoardgames.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.entities.Leilao;
import br.com.LeiloaBoardgames.repository.LeilaoRepository;

@Service
public class LeilaoService {
    LeilaoRepository repository;

    public LeilaoService(LeilaoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Leilao leilao) {
        leilao.setDataInicio(LocalDateTime.now());
        repository.save(leilao);
    }

    public void atualizar(Integer id, Leilao leilao) {
        // TODO: mapeamento para atualizar o leilao
        Optional<Leilao> leilaoAtual = repository.findById(id);
        if (leilaoAtual.isPresent()) {
            leilao = leilaoAtual.get();
            repository.save(leilao);
        }
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Leilao buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
