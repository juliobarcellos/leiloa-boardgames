package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        validarUsuarioExistente(usuario);
        return repository.save(usuario);
    }


    public Usuario atualizar(Integer id, Usuario usuario) throws NotFoundException {
        Usuario usuarioAtual = buscarPorId(id);

        validarUsuarioExistente(usuario);

        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        usuarioAtual.setSenha(usuario.getSenha());
        return repository.save(usuarioAtual);
    }



    public void deletar(Integer id) throws NotFoundException {
        Usuario usuarioExistente = buscarPorId(id);
        repository.delete(usuarioExistente);
    }

    public Usuario buscarPorId(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    private void validarUsuarioExistente(Usuario usuario) {
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }
        if (repository.existsByCpf(usuario.getCpf())) {
            throw new BusinessException("CPF já cadastrado");
        }
        if (repository.existsByUsuario(usuario.getUsuario())) {
            throw new BusinessException("Usuário já cadastrado");
        }
    }
}
