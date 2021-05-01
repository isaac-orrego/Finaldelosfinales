package com.example.finaldelosfinales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var RecyclerView: RecyclerView
    lateinit var adaptador:Adaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerView = findViewById(R.id.rvperro)
        buscaperro()
    }


    private fun buscaperro() {
        doAsync {
            val call = getRetrofit().create(Api::class.java).tomarPorNombre("chihuahua/images").execute()
            val perrosky = call.body() as Perro

            uiThread {
                adaptador = Adaptador(perrosky.imagenes)
                RecyclerView.setHasFixedSize(true)
                RecyclerView.layoutManager = LinearLayoutManager(applicationContext)
                RecyclerView.adapter = adaptador


            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/").addConverterFactory(
                GsonConverterFactory.create()).build()
    }





}
