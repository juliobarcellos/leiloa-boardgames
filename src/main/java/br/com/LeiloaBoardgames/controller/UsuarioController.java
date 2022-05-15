package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;
<<<<<<< HEAD
import br.com.LeiloaBoardgames.exceptions.ApiErrors;
import br.com.LeiloaBoardgames.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
=======
import br.com.LeiloaBoardgames.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
>>>>>>> e7e4d7d (refact - merge master)

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
<<<<<<< HEAD
    public UsuarioResponse create(@Valid @RequestBody UsuarioRequest request) {
        Usuario entity = mapper.map(request, Usuario.class);
        entity = service.save(entity);
        return mapper.map(entity, UsuarioResponse.class);
=======
    public UsuarioResponse create(@RequestBody UsuarioRequest usuario) {
        Usuario entity = mapper.map(usuario, Usuario.class);
        return mapper.map(service.save(entity), UsuarioResponse.class);
>>>>>>> e7e4d7d (refact - merge master)
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        return new ApiErrors(bindingResult);
    }


}
