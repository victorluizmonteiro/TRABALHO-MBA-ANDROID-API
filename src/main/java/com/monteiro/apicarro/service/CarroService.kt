package com.monteiro.apicarro.service

import com.monteiro.apicarro.model.Carro
import com.monteiro.apicarro.repository.CarroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CarroService

@Autowired
constructor(private val carroRepository: CarroRepository) {

    fun salvar(carro: Carro): Carro {


        carroRepository.save(carro)
        return carro

    }

    fun listarTodos(): List<Carro> {
        return carroRepository.findAll()
    }


    fun buscarPelaPlaca(placa: String): Carro {


        return carroRepository.findByPlaca(placa)


    }

    fun remover(carro: Carro) {

        carroRepository.delete(carro)
    }


}
