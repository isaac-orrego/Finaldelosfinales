package com.example.finaldelosfinales

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    fun tomarPorNombre(@Url url: String): Call<Perro>
}