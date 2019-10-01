package br.com.piscioneri.stocks.stock.domain.useCase.model

data class StockModel(
    val name: String,
    val code: String,
    val recommendations: Number,
    val image: String,
    val value: Double
)
