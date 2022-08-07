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
import java.util.Objects;

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

        if (jogoAtualizar.getNome() != null && !Objects.equals(jogoAtualizar.getNome(), jogoAtual.getNome())) {
            if (validarJogoExistente(jogoAtualizar.getNome())) {
                throw new BusinessException("Jogo já cadastrado com esse nome");
            }
            jogoAtual.setNome(jogoAtualizar.getNome());
        }
        if (jogoAtualizar.getDescricao() != null && !Objects.equals(jogoAtualizar.getDescricao(), jogoAtual.getDescricao())) {
            if (validarJogoExistente(jogoAtualizar.getDescricao())) {
                throw new BusinessException("Jogo já cadastrado com essa descrição");
            }
            jogoAtual.setDescricao(jogoAtualizar.getDescricao());
        }
        if (jogoAtualizar.getCategoria() != null && !Objects.equals(jogoAtualizar.getCategoria(), jogoAtual.getCategoria().getNome())) {
            Categoria categoria = categoriaService.buscarPorNome(jogoAtualizar.getCategoria());
            jogoAtual.setCategoria(categoria);
        }


        if (jogoAtualizar.getFichaTecnica() != null && !Objects.equals(jogoAtualizar.getFichaTecnica(), jogoAtual.getFichaTecnica())) {
            jogoAtual.setFichaTecnica(jogoAtualizar.getFichaTecnica());
        }
        if (jogoAtualizar.getQuantidadeJogadores() != null && !Objects.equals(jogoAtualizar.getQuantidadeJogadores(), jogoAtual.getQuantidadeJogadores())) {
            jogoAtual.setQuantidadeJogadores(jogoAtualizar.getQuantidadeJogadores());
        }
        if (jogoAtualizar.getImagemCapa() != null && !Objects.equals(jogoAtualizar.getImagemCapa(), jogoAtual.getImagemCapa())) {
            jogoAtual.setImagemCapa(jogoAtualizar.getImagemCapa());
        }
        if (jogoAtualizar.getComplemento() != null && !Objects.equals(jogoAtualizar.getComplemento(), jogoAtual.getComplemento())) {
            jogoAtual.setComplemento(jogoAtualizar.getComplemento());
        }

    }

    public List<Jogo> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
    }

    public List<Jogo> buscarPorCategoria(String categoriaNome) {
        Categoria categoria = categoriaService.buscarPorNome(categoriaNome);
        return repository.findByCategoria(categoria).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
    }

//    public List<Jogo> buscarPorListaCategoria(List<String> categorias) {
//        return repository.findByCategoriaIsIn(categorias).orElseThrow(() -> new NoSuchElementException("Jogo não encontrado"));
//    }
}
