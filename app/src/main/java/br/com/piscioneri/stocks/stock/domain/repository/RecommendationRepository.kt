package br.com.piscioneri.stocks.stock.domain.repository

import br.com.piscioneri.stocks.stock.domain.repository.dto.ResponseRecommendations
import io.reactivex.Single

interface RecommendationRepository {
    fun loadStocks():Single<ResponseRecommendations>
}