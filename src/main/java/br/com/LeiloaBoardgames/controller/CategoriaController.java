package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Categoria;
import br.com.LeiloaBoardgames.domain.request.categoria.CategoriaRequest;
import br.com.LeiloaBoardgames.domain.response.categoria.CategoriaRespose;
import br.com.LeiloaBoardgames.exceptions.ApiErrors;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.mapper.CategoriaMapper;
import br.com.LeiloaBoardgames.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;
    private final CategoriaMapper mapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaRespose create(@Valid @RequestBody CategoriaRequest request) {
        Categoria entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toResponse(entity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @Valid @RequestBody CategoriaRequest request) {
        service.atualizar(id, request);
    }

    @GetMapping("/categorias")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaRespose> findAll() {
        List<Categoria> entity = service.buscarTodos();
        return mapper.toListResponse(entity);
    }

    @DeleteMapping("/categorias/{id}")
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
