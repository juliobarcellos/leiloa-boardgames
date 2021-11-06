package br.com.LeiloaBoardgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @GetMapping
    public String getEndereco() {
        return "Rua dos bobos, 0";
    }
}
