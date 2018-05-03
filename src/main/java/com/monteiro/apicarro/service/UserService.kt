package com.monteiro.apicarro.service

import com.monteiro.apicarro.model.User
import com.monteiro.apicarro.repository.CarroRepository
import com.monteiro.apicarro.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class UserService
    @Autowired
    constructor(private val userRepository: UserRepository){

        fun salvar (user : User) {
            userRepository.save(user)
        }

    fun buscarPeloUsername(username:String):User{

        return userRepository.findByUsername(username)
    }

    }

