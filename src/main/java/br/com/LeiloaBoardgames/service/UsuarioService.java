package br.com.LeiloaBoardgames.service;

import java.util.Optional;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
<<<<<<< HEAD
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
=======
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
>>>>>>> e7e4d7d (refact - merge master)
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void atualizar(Integer id, Usuario usuario) throws NotFoundException {
        Usuario usuarioExistente = buscar(id);
        // TODO: mapeamento para atualizar o usuario
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());

        repository.save(usuarioExistente);
    }

    public void deletar(Integer id) throws NotFoundException {
        Usuario usuarioExistente = buscar(id);
        repository.delete(usuarioExistente);
    }

    public Usuario buscar(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}
