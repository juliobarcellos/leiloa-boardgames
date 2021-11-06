package br.com.LeiloaBoardgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {
    @GetMapping
    public String getLeilao() {
        return "Leilão";
    }
}
