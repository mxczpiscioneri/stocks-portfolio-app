package br.com.piscioneri.stocks.stock.data

import br.com.piscioneri.stocks.stock.domain.repository.dto.ResponseRecommendations
import io.reactivex.Single
import retrofit2.http.GET

interface RecommendationApi {
    @GET("/recommendations")
    fun list(): Single<ResponseRecommendations>
}
