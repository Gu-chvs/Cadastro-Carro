package com.empresa.cadastro_carro.controller;

import com.empresa.cadastro_carro.business.CarroService;
import com.empresa.cadastro_carro.infrasctruture.entitys.Carro;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<Void> salvarCarro(@RequestBody Carro carro){
        carroService.salvarCarro(carro);
        return ResponseEntity.ok().build();
    }

}
