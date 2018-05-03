package com.monteiro.apicarro.controller

import com.monteiro.apicarro.model.User
import com.monteiro.apicarro.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private val userService: UserService? = null

    @PostMapping
    fun cadastrar(@RequestBody user:User){

        userService.salvar(user)

    }
    @GetMapping("/{username}")
    fun buscarPorUsername(@PathVariable("username")username:String):User{
        return userService!!.buscarPeloUsername(username);
    }
}