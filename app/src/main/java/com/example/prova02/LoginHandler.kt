package com.example.prova02

import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginHandler {
    @POST("/login")
    fun logar(@Body user: Usuario): Callback<Usuario>
}