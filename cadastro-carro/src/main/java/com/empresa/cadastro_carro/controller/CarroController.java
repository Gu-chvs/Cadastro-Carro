package com.empresa.cadastro_carro.controller;

import com.empresa.cadastro_carro.business.CarroService;
import com.empresa.cadastro_carro.infrasctruture.entitys.Carro;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Carro> buscarCarroPorPlaca(@RequestParam String placa){
        return ResponseEntity.ok(carroService.buscarCarroPorPlaca(placa));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCarroPorPlaca(@RequestParam String placa){
        carroService.deletarCarroPorPlaca(placa);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCarroPorId(@RequestParam Integer id,
                                                    @RequestBody Carro carro){
        carroService.atualizarCarroPorId(id, carro);
        return ResponseEntity.ok().build();
    }




}
