package com.monteiro.apicarro.model


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "carro")
class Carro( @Id
             var placa: String?,

             var marca: String?,

             var modelo: String?,


             var anoLancamento: Int,

             var urlImagem: String?,


             var valor: Double?) {

}
