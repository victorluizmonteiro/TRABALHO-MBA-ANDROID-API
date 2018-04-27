package com.monteiro.apicarro.service;

import com.monteiro.apicarro.model.Carro;
import com.monteiro.apicarro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro salvar(Carro carro) {


        carroRepository.save(carro);
        return carro;

    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }



    public Carro buscarPelaPlaca(String placa) {
        Carro carro =carroRepository.findByPlaca(placa);


        return carro;


    }

    public void remover(Carro carro) {

        carroRepository.delete(carro);
    }


}
