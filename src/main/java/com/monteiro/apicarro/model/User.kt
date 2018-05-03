package com.monteiro.apicarro.model

import org.springframework.data.annotation.Id

data class User(@Id var username:String,
                var password:String,
                var name:String,
                var email:String)