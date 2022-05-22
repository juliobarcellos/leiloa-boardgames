package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        validarUsuarioExistente(usuario);
        return repository.save(usuario);
    }


    public Usuario atualizar(Integer id, Usuario usuario) throws NoSuchElementException {
        Usuario usuarioAtual = buscarPorId(id);

        validarUsuarioExistente(usuario);

        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setSenha(usuario.getSenha());
        return repository.save(usuarioAtual);
    }


    public Integer deletar(Integer id) throws NoSuchElementException {
        Usuario usuarioExistente = buscarPorId(id);
        if (!usuarioExistente.getAtivo()) {
            throw new BusinessException("Usuário já deletado");
        }
        repository.delete(usuarioExistente);
        return usuarioExistente.getIdUsuario();
    }


    public Usuario buscarPorId(Integer id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }

    private void validarUsuarioExistente(Usuario usuario) {
        if (repository.existsByEmail(usuario.getEmail()) && usuario.getAtivo()) {
            throw new BusinessException("Email já cadastrado");
        }
        if (repository.existsByCpf(usuario.getCpf()) && usuario.getAtivo()) {
            throw new BusinessException("CPF já cadastrado");
        }
        if (repository.existsByUsuario(usuario.getUsuario()) && usuario.getAtivo()) {
            throw new BusinessException("Usuário já cadastrado");
        }
    }

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }
}
