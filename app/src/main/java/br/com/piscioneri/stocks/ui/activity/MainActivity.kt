package br.com.piscioneri.stocks.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.toolbar.*
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.model.Stock
import br.com.piscioneri.stocks.ui.adapter.StockListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = StockListAdapter(notes(), this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = layoutManager
    }

    private fun notes(): List<Stock> {
        return listOf(
            Stock(
                "Petrobras",
                "PETR4",
                14,
                "https://br.advfn.com/common/images/companies/BOV_PETR4.png",
                25.0
            ),
            Stock(
                "Magazine Luiza",
                "MGLU3",
                10,
                "https://br.advfn.com/common/images/companies/BOV_MGLU3.png",
                40.0
            ),
            Stock(
                "Petrobras",
                "PETR4",
                14,
                "https://cdn.toroinvestimentos.com.br/corretora/images/quote/PETR.svg",
                25.0
            )
        )
    }
}
