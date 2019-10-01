package br.com.piscioneri.stocks.stock

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.piscioneri.stocks.RetrofitInitializer
import br.com.piscioneri.stocks.stock.domain.repository.dto.StockDto
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StockViewModel:ViewModel() {
    var stocks : MutableLiveData<List<StockDto>> = MutableLiveData()

    init {
        loadStocks()
    }

    private fun loadStocks() {
        val call = RetrofitInitializer().recommendatioApi().list()
        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val recommendations: List<StockDto> = it.records
                stocks.value = recommendations
            },{
                Log.e("onFailure error", it.message)
            })
    }

    override fun onCleared() {
        super.onCleared()
    }
}