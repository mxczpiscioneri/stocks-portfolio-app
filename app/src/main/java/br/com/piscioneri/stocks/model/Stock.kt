package br.com.piscioneri.stocks.model

data class ResponseRecommendations(
    val meta: Meta,
    val records: List<Stock>
)

data class Meta(
    val recordCount: Number,
    val recordTotal: Number,
    val offset: Number,
    val limit: Number
)

data class Stock(
    val name: String,
    val code: String,
    val recommendations: Number,
    val image: String,
    val value: Double
)
