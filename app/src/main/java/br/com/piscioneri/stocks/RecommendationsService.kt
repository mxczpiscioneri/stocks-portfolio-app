package br.com.piscioneri.stocks

import br.com.piscioneri.stocks.model.ResponseRecommendations
import retrofit2.Call
import retrofit2.http.GET

interface RecommendationService {
    @GET("/recommendations")
    fun list(): Call<ResponseRecommendations>
}
