package com.monteiro.apicarro.repository


import com.monteiro.apicarro.model.Carro
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarroRepository : MongoRepository<Carro, String> {

    fun findByPlaca(placa: String): Carro
}
