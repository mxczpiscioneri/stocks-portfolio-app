package br.com.piscioneri.stocks.injections

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    fun retrofit() = Retrofit.Builder()
        .baseUrl("https://stocks-portfolio-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}