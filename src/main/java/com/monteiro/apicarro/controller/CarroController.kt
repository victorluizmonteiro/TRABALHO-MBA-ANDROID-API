package com.monteiro.apicarro.controller

import com.monteiro.apicarro.model.Carro
import com.monteiro.apicarro.service.CarroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/carro")
class CarroController {
    @Autowired
    private val carroService: CarroService? = null


    @PostMapping
    fun cadastrar(@RequestBody carro: Carro) {

        carroService!!.salvar(carro)


    }

    @GetMapping("/{placa}")
    fun buscarPelaPlaca(@PathVariable("placa") placa: String): Carro {

        return carroService!!.buscarPelaPlaca(placa)

    }


    @DeleteMapping("/deletar/{placa}")
    fun deletar(@PathVariable("id") placa: String) {
        val carro = carroService!!.buscarPelaPlaca(placa)
        carroService.remover(carro)

    }

    @GetMapping
    fun buscarTodos(): List<Carro> {
        return carroService!!.listarTodos()
    }
}
