package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
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
