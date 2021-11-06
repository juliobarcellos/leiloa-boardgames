package br.com.LeiloaBoardgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lance")
public class LanceController {
    @GetMapping
    public String lance() {
        return "Lance";
    }
}
