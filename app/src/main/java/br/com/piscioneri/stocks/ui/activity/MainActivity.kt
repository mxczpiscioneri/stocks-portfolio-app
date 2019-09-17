package br.com.piscioneri.stocks.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.piscioneri.stocks.R
import br.com.piscioneri.stocks.model.Note
import br.com.piscioneri.stocks.ui.adapter.NoteListAdapter
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = note_list_recyclerview
        recyclerView.adapter = NoteListAdapter(notes(), this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = layoutManager
    }

    private fun notes(): List<Note> {
        return listOf(
            Note("Leitura",
                "Livro de Kotlin com Android"),
            Note("Pesquisa",
                "Como posso melhorar o código dos meus projetos"),
            Note("Estudo",
                "Como sincronizar minha App com um Web Service"))
    }
}
