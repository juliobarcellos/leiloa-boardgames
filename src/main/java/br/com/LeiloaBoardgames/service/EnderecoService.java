package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.LeiloaBoardgames.domain.Endereco;
import br.com.LeiloaBoardgames.repository.EnderecoRepository;

@Service
public class EnderecoService {
    EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Endereco endereco) {
        repository.save(null);
    }

    public void atualizar(Long id, Endereco endereco) {
        // TODO: mapeamento para atualizar o endereco
        Optional<Endereco> enderecoAtual = repository.findById(id);
        if (enderecoAtual.isPresent()) {
            endereco = enderecoAtual.get();
            repository.save(endereco);
        }
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Endereco buscar(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
