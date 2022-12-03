package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Usuario;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.usuario.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioCreateResponse;
import br.com.LeiloaBoardgames.domain.response.usuario.UsuarioResponse;
import br.com.LeiloaBoardgames.exceptions.ApiErrors;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.mapper.UsuarioMapper;
import br.com.LeiloaBoardgames.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioCreateResponse create(@Valid @RequestBody UsuarioCreateRequest request) {
        Usuario entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toCreateResponse(entity);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @Valid @RequestBody UsuarioAtualizarRequest request) {
        service.atualizar(id, request);
    }


    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse findById(@PathVariable("id") Integer id) {
        Usuario entity = null;
        entity = service.buscarPorId(id);
        return mapper.toResponse(entity);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> findAll() {
        List<Usuario> entity = service.buscarTodos();
        return mapper.toListResponse(entity);
    }

    @GetMapping("/usuarios/inativos")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> findAllInactive() {
        List<Usuario> entity = service.buscarTodosDesativados();
        return mapper.toListResponse(entity);
    }


    @DeleteMapping("/usuarios/{id}")
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
