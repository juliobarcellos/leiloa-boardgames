package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.Usuario;
import br.com.LeiloaBoardgames.domain.request.UsuarioRequest;
import br.com.LeiloaBoardgames.domain.response.UsuarioResponse;
import br.com.LeiloaBoardgames.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody UsuarioRequest usuario) {
        Usuario entity = mapper.map(usuario, Usuario.class);
        return mapper.map(service.save(entity), UsuarioResponse.class);
    }
}
