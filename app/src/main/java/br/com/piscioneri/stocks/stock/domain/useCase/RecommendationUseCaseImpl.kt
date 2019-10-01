package br.com.piscioneri.stocks.stock.domain.useCase

import br.com.piscioneri.stocks.stock.domain.repository.RecommendationRepository
import br.com.piscioneri.stocks.stock.domain.useCase.model.StockModel
import io.reactivex.Single

//class RecommendationUseCaseImpl(private val repository: RecommendationRepository) :
//    RecommendationRepository {
//    override fun loadStocks(): Single<List<StockModel>> = repository.loadStocks().map {response ->
//        response.records.map {
//            Stock(it.name, it.code, it.recommendations, it.image, it.value)
//        }
//    }
//}