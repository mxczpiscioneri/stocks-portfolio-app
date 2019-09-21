package br.com.piscioneri.stocks.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.toolbar.*
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.RetrofitInitializer
import br.com.piscioneri.stocks.model.ResponseRecommendations
import br.com.piscioneri.stocks.model.Stock
import br.com.piscioneri.stocks.ui.adapter.StockListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        val call = RetrofitInitializer().recommendatioService().list()
        call.enqueue(object : Callback<ResponseRecommendations> {
            override fun onResponse(call: Call<ResponseRecommendations?>?, response: Response<ResponseRecommendations?>?) {
                response?.body()?.let {
                    val recommendations: List<Stock> = it.records
                    configureList(recommendations)
                }
            }

            override fun onFailure(call: Call<ResponseRecommendations?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })

    }

    private fun configureList(recommendations: List<Stock>) {
        val recyclerView = note_list_recyclerview
        recyclerView.adapter = StockListAdapter(recommendations, this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
