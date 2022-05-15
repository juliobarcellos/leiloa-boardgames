package br.com.LeiloaBoardgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perguntas")
public class PerguntasController {

    @GetMapping
    public String getPerguntas() {
        return "Perguntas";
    }
}
