package com.monteiro.apicarro.repository

import com.monteiro.apicarro.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {

    fun findByUsername(username:String):User
}