package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;

public class UsuarioService {

    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvar(Usuario usuario) {
        repository.save(null);
    }

    public void atualizar(Integer id, Usuario usuario) {
        // TODO: mapeamento para atualizar o usuario
        Optional<Usuario> usuarioAtual = repository.findById(id);
        if (usuarioAtual.isPresent()) {
            usuario = usuarioAtual.get();
            repository.save(usuario);
        }
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Usuario buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
