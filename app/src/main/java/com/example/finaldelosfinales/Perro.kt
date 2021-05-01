package com.example.finaldelosfinales

import com.google.gson.annotations.SerializedName

data class Perro(
    @SerializedName("message") var imagenes:List<String>
)