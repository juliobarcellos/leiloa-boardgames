package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario usuario) {
        validarUsuarioExistente(usuario);
        usuario.setAtivo(true);
        return repository.save(usuario);
    }


    public Usuario atualizar(Integer id, UsuarioAtualizarRequest usuarioAtualizar) throws NoSuchElementException {
        Usuario usuarioAtual = buscarPorId(id);

        validarCamposParaAtualizar(usuarioAtualizar, usuarioAtual);

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

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Integer id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }

    private void validarUsuarioExistente(Usuario usuario) {

        validarEmailExistente(usuario.getEmail());

        validarCpfExistente(usuario.getCpf());

        validarUsuarioExistente(usuario.getUsuario());
        usuario.setAtivo(true);
    }

    private void validarEmailExistente(String email) {
        repository.findByEmailIgnoreCase(email).ifPresent(u -> {
            if (u.getAtivo().equals(true)) {
                throw new BusinessException("Email já cadastrado");
            }
        });
    }

    private void validarCpfExistente(String cpf) {
        repository.findByCpfIgnoreCase(cpf).ifPresent(u -> {
            if (u.getAtivo().equals(true)) {
                throw new BusinessException("CPF já cadastrado");
            }
        });
    }

    private void validarUsuarioExistente(String usuario) throws BusinessException {
        repository.findByUsuarioIgnoreCase(usuario).ifPresent(u -> {
            if (u.getAtivo().equals(true)) {
                throw new BusinessException("Usuário já cadastrado");
            }
        });
    }

    private void validarCamposParaAtualizar(UsuarioAtualizarRequest usuarioAtualizar, Usuario usuarioAtual) {
        if (Objects.nonNull(usuarioAtualizar.getEmail())) {
            validarEmailExistente(usuarioAtualizar.getEmail());
        }
        if (Objects.nonNull(usuarioAtualizar.getUsuario())) {
            validarUsuarioExistente(usuarioAtualizar.getUsuario());
        }
        usuarioAtual.setNome(Objects.nonNull(usuarioAtualizar.getNome()) ? usuarioAtualizar.getNome(): usuarioAtual.getNome());
        usuarioAtual.setUsuario(Objects.nonNull(usuarioAtualizar.getUsuario()) ? usuarioAtualizar.getUsuario(): usuarioAtual.getUsuario());
        usuarioAtual.setEmail(Objects.nonNull(usuarioAtualizar.getEmail()) ? usuarioAtualizar.getEmail(): usuarioAtual.getEmail());
        usuarioAtual.setDataNascimento(Objects.nonNull(usuarioAtualizar.getDataNascimento()) ? LocalDate.parse(usuarioAtualizar.getDataNascimento()) : usuarioAtual.getDataNascimento());
        usuarioAtual.setTelefone(Objects.nonNull(usuarioAtualizar.getTelefone()) ? usuarioAtualizar.getTelefone(): usuarioAtual.getTelefone());
    }
}
