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
    public Carro cadastrar(@RequestBody Carro carro) {
        try {
            carroService.salvar(carro);
            return carro;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{placa}")
    public Carro buscarPelaPlaca(@PathVariable("placa") String placa) {
        Optional<Carro> carro = carroService.buscarPelaPlaca(placa);


        if (!carro.isPresent()) {
            return null;
        }

        return carro.get();


    }



    @DeleteMapping("/deletar/{id}")
    public Carro deletar(@PathVariable("id") String id) {
        Optional<Carro> carro = carroService.buscarPorId(id);
        try {
            carroService.remover(carro.get());
            return carro.get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping
    public List<Carro> buscarTodos() {
        return carroService.listarTodos();
    }
}
