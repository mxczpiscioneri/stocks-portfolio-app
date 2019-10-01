package br.com.piscioneri.stocks.stock.domain.repository.dto

data class ResponseRecommendations(
    val meta: Meta,
    val records: List<StockDto>
)

data class Meta(
    val recordCount: Number,
    val recordTotal: Number,
    val offset: Number,
    val limit: Number
)

data class StockDto(
    val name: String,
    val code: String,
    val recommendations: Number,
    val image: String,
    val value: Double
)
