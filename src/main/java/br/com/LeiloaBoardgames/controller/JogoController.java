package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.entities.Jogo;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.jogo.JogoCreateRequest;
import br.com.LeiloaBoardgames.domain.response.jogo.JogoRespose;
import br.com.LeiloaBoardgames.exceptions.ApiErrors;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.mapper.JogoMapper;
import br.com.LeiloaBoardgames.service.CategoriaService;
import br.com.LeiloaBoardgames.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
public class JogoController {

    private final JogoService service;
    private final CategoriaService categoriaService;
    private final JogoMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogoRespose create(@Valid @RequestBody JogoCreateRequest request) {
        List<Categoria> categorias = categoriaService.buscarTodos(request.getCategoria());
        Jogo entity = mapper.toEntity(request);
        entity.setCategoria(categorias);
        entity = service.save(entity);
        return mapper.toResponse(entity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @Valid @RequestBody JogoAtualizarRequest request) {
        service.atualizar(id, request);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JogoRespose findById(@PathVariable("id") Integer id) {
        Jogo entity = null;
        entity = service.buscarPorId(id);
        return mapper.toResponse(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JogoRespose> findAll() {
        List<Jogo> entity = service.buscarTodos();
        return mapper.toListResponse(entity);
    }


    @GetMapping("/categoria/{categoria}")
    @ResponseStatus(HttpStatus.OK)
    public List<JogoRespose> findAllByCategoria(@PathVariable("categoria") String categoria) {
        List<Jogo> entity = service.buscarPorCategoria(categoria);
        return mapper.toListResponse(entity);
    }


    @DeleteMapping("/jogos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.deletar(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return new ApiErrors(bindingResult);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(BusinessException ex) {
        return new ApiErrors(ex);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleValidationExceptions(NoSuchElementException ex) {
        return new ApiErrors(ex);
    }


}
