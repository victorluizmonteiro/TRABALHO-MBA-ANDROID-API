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
    public void cadastrar(@RequestBody Carro carro) {

            carroService.salvar(carro);



    }

    @GetMapping("/{placa}")
    public Carro buscarPelaPlaca(@PathVariable("placa") String placa) {
        Carro carro = carroService.buscarPelaPlaca(placa);

        return carro;

    }



    @DeleteMapping("/deletar/{placa}")
    public void deletar(@PathVariable("id") String placa) {
       Carro carro = carroService.buscarPelaPlaca(placa);
       carroService.remover(carro);

    }

    @GetMapping
    public List<Carro> buscarTodos() {
        return carroService.listarTodos();
    }
}
