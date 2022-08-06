package br.com.LeiloaBoardgames.service;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoAtualizarRequest;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.repository.CategoriaRepository;
import br.com.LeiloaBoardgames.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class JogoService {
    //TODO: atualizar não funciona
    private final JogoRepository repository;
    private final CategoriaService categoriaService;

    public Jogo save(Jogo jogo) {
        if (validarJogoExistente(jogo.getNome())) {
            throw new BusinessException("Jogo já cadastrado com esse nome");
        }
        return repository.save(jogo);
    }

    public Jogo atualizar(Integer id, JogoAtualizarRequest jogoAtualizar) throws NoSuchElementException {
        Jogo jogoAtual = buscarPorId(id);

        validarCamposParaAtualizar(jogoAtualizar, jogoAtual);

        return repository.save(jogoAtual);
    }

    public void deletar(Integer id) throws NoSuchElementException {
        Jogo jogoExistente = buscarPorId(id);
        repository.delete(jogoExistente);
    }

    public List<Jogo> buscarTodos() {
        return repository.findAll();
    }

    public Jogo buscarPorId(Integer id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
    }

    private Boolean validarJogoExistente(String nomeJogo) {
        return repository.existsByNome(nomeJogo);
    }


    private void validarCamposParaAtualizar(JogoAtualizarRequest jogoAtualizar, Jogo jogoAtual) {

        if (jogoAtualizar.getNome() != null) {
            if (validarJogoExistente(jogoAtualizar.getNome())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setNome(jogoAtualizar.getNome());
        }
        if (jogoAtualizar.getDescricao() != null) {
            if (validarJogoExistente(jogoAtualizar.getDescricao())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setDescricao(jogoAtualizar.getDescricao());
        }
        if (jogoAtualizar.getCategoria() != null) {

            jogoAtual.getCategoria().addAll(jogoAtualizar.getCategoria());
        }


        if (jogoAtualizar.getFichaTecnica() != null) {
            if (validarJogoExistente(jogoAtualizar.getFichaTecnica())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setFichaTecnica(jogoAtualizar.getFichaTecnica());
        }
        if (jogoAtualizar.getQuantidadeJogadores() != null) {
            if (validarJogoExistente(jogoAtualizar.getQuantidadeJogadores())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setQuantidadeJogadores(jogoAtualizar.getQuantidadeJogadores());
        }
        if (jogoAtualizar.getImagemCapa() != null) {
            if (validarJogoExistente(jogoAtualizar.getImagemCapa())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setImagemCapa(jogoAtualizar.getImagemCapa());
        }
        if (jogoAtualizar.getComplemento() != null) {
            if (validarJogoExistente(jogoAtualizar.getComplemento())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setComplemento(jogoAtualizar.getComplemento());
        }

    }

    public List<Jogo> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
    }

    public List<Jogo> buscarPorCategoria(String categoria) {
        List<Categoria> categorias = categoriaService.buscarTodosPorNome(categoria);
        return repository.findByCategoriaIsIn(categorias).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
    }

//    public List<Jogo> buscarPorListaCategoria(List<String> categorias) {
//        return repository.findByCategoriaIsIn(categorias).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
//    }
}
