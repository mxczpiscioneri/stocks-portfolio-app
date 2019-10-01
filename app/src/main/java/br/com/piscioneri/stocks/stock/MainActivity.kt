package br.com.piscioneri.stocks.stock

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.stock.adapter.StockListAdapter
import br.com.piscioneri.stocks.stock.domain.repository.dto.StockDto
import br.com.piscioneri.stocks.stock.domain.useCase.model.StockModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val stockViewModel: StockViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        progressBar.visibility = View.VISIBLE

        stockViewModel.stocks.observe(this, Observer {
            configureList(it)

            progressBar.visibility = View.GONE
        })
    }

    private fun configureList(recommendations: List<StockDto>) {
        val recyclerView = note_list_recyclerview
        recyclerView.adapter = StockListAdapter(recommendations, this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
