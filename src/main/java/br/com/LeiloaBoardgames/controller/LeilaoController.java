package br.com.LeiloaBoardgames.controller;

import br.com.LeiloaBoardgames.domain.entities.Leilao;
import br.com.LeiloaBoardgames.domain.request.leilao.LeilaoCreateRequest;
import br.com.LeiloaBoardgames.domain.response.leilao.LeilaoCreateResponse;
import br.com.LeiloaBoardgames.mapper.LeilaoMapper;
import br.com.LeiloaBoardgames.service.LeilaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/leilao")
@RequiredArgsConstructor
public class LeilaoController {

    private final LeilaoMapper mapper;
    private final LeilaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeilaoCreateResponse create(@Valid @RequestBody LeilaoCreateRequest request) {

        Leilao entity = mapper.toEntity(request);
        service.salvar(entity);
        return mapper.toCreateResponse(entity);
    }

    @GetMapping
    public String getLeilao() {
        return "Leilão";
    }
}
