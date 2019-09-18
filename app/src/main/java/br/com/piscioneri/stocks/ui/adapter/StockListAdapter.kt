package br.com.piscioneri.stocks.ui.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.model.Stock
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_item_layout.view.*

class StockListAdapter(private val stocks: List<Stock>, private val context: Context) : RecyclerView.Adapter<StockListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = stocks[position]
        val uri = Uri.parse(stock.image)

        Glide
            .with(context)
            .load(uri)
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
        private val tvRecommendations = itemView.recommendations
        private val tvPrice = itemView.price
        val imgThumb = itemView.image

        fun bindView(stock: Stock) {
            tvName.text = stock.name
            tvCode.text = stock.code
            tvRecommendations.text = stock.recommendations.toString()
            tvPrice.text = stock.price.toString()
        }

    }
}
