package com.monteiro.apicarro.repository;


import com.monteiro.apicarro.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends MongoRepository<Carro,String> {

     Carro findByPlaca(String placa);
}
