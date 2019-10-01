package br.com.piscioneri.stocks.injections

import br.com.piscioneri.stocks.stock.StockViewModel
import br.com.piscioneri.stocks.stock.data.RecommendationApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single {
        NetworkClient.retrofit() as Retrofit
    }

}

val apiModule = module {
    single {
        get<Retrofit>().create(RecommendationApi::class.java) as RecommendationApi
    }
}

val viewModelModule = module {
    viewModel {
        StockViewModel()
    }
}