package br.com.piscioneri.stocks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://stocks-portfolio-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun recommendatioService() = retrofit.create(RecommendationService::class.java)
}