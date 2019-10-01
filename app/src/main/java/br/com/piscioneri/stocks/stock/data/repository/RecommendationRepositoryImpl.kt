package br.com.piscioneri.stocks.stock.data.repository

import br.com.piscioneri.stocks.stock.data.RecommendationApi
import br.com.piscioneri.stocks.stock.domain.repository.RecommendationRepository
import br.com.piscioneri.stocks.stock.domain.repository.dto.ResponseRecommendations
import io.reactivex.Single

class RecommendationRepositoryImpl(private val recommendationApi: RecommendationApi) : RecommendationRepository {
    override fun loadStocks(): Single<ResponseRecommendations> = recommendationApi.list()
}