package br.com.piscioneri.stocks.stock.domain.useCase

import br.com.piscioneri.stocks.stock.domain.useCase.model.StockModel
import io.reactivex.Single

interface RecommendationUseCase {
    fun loadStocks(): Single<List<StockModel>>
}