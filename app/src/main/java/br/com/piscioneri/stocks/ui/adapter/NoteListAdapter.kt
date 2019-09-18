package br.com.piscioneri.stocks.ui.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.model.Note
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_item_layout.view.*

class NoteListAdapter(private val notes: List<Note>, private val context: Context) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        val uri = Uri.parse(note.image)

        Glide
            .with(context)
            .load(uri)
            .into(holder.imgThumb)

        holder.bindView(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.name
        val tvCode = itemView.code
        val tvRecommendations = itemView.recommendations
        val tvPrice = itemView.price
        val imgThumb = itemView.image

        fun bindView(note: Note) {
            tvName.text = note.name
            tvCode.text = note.code
            tvRecommendations.text = note.recommendations.toString()
            tvPrice.text = note.price.toString()
        }

    }
}
