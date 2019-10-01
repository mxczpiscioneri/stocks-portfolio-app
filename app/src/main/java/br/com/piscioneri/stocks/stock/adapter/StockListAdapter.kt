package br.com.piscioneri.stocks.stock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item_layout.view.*
import com.bumptech.glide.Glide
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.stock.domain.repository.dto.StockDto
import java.text.NumberFormat
import java.util.*

class StockListAdapter(private val stocks: List<StockDto>, private val context: Context) : RecyclerView.Adapter<StockListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = stocks[position]

        Glide
            .with(context)
            .load(stock.image)
            .into(holder.imgThumb)

        holder.bindView(stock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.name
        private val tvCode = itemView.code
        private val btnRecommendations = itemView.recommendations
        private val tvPrice = itemView.price
        val imgThumb = itemView.image

        fun bindView(stock: StockDto) {
            tvName.text = stock.name
            tvCode.text = stock.code
            btnRecommendations.setText(stock.recommendations.toString())

            val ptBR = Locale("pt", "BR")
            val currencyFormat = NumberFormat.getCurrencyInstance(ptBR)
            tvPrice.text = currencyFormat.format(stock.value)
        }

    }
}
