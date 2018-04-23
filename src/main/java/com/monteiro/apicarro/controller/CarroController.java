package com.monteiro.apicarro.controller;

import com.monteiro.apicarro.model.Carro;
import com.monteiro.apicarro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;


    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody Carro carro) {
        try {
            carroService.salvar(carro);
            return ResponseEntity.status(HttpStatus.CREATED).body(carro);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Optional<Carro>> buscarPelaPlaca(@PathVariable("placa") String placa) {
        Optional<Carro> carro = carroService.buscarPelaPlaca(placa);


        if (!carro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.ok().body(carro);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> buscarPeloId(@PathVariable("id") String id) {
        Optional<Carro> carro = carroService.buscarPorId(id);

        if (!carro.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok().body(carro);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Carro> deletar(@PathVariable("id") String id) {
        Optional<Carro> carro = carroService.buscarPorId(id);
        try {
            carroService.remover(carro.get());
            return ResponseEntity.ok(carro.get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Carro>> buscarTodos() {
        return ResponseEntity.ok(carroService.listarTodos());
    }
}
