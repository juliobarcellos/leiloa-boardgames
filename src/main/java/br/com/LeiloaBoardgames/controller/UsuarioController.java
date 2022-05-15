package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioAtualizarRequest;
import br.com.LeiloaBoardgames.domain.request.UsuarioCreateRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;
import br.com.LeiloaBoardgames.exceptions.ApiErrors;
import br.com.LeiloaBoardgames.exceptions.BusinessException;
import br.com.LeiloaBoardgames.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@Valid @RequestBody UsuarioCreateRequest request) {
        Usuario entity = mapper.map(request, Usuario.class);
        entity = service.save(entity);
        return mapper.map(entity, UsuarioResponse.class);
    }


//    @PutMapping("/usuarios/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public UsuarioResponse update(@PathVariable Integer id, @Valid @RequestBody UsuarioAtualizarRequest request) {
//        Usuario entity = mapper.map(request, Usuario.class);
//        entity = service.atualizar(id, entity);
//        return mapper.map(entity, UsuarioResponse.class);
//    }

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


}
