package br.com.piscioneri.stocks

import br.com.piscioneri.stocks.stock.data.RecommendationApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://stocks-portfolio-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun recommendatioApi() = retrofit.create(RecommendationApi::class.java)
}