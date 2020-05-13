package com.example.desenvsegtrimtp1.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desenvsegtrimtp1.AtualizarLivroActivity
import com.example.desenvsegtrimtp1.R
import com.example.desenvsegtrimtp1.models.Livro
import com.example.desenvsegtrimtp1.models.LivroComAutor
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_livro.view.*

class LivroAdapter (livros : List<LivroComAutor>, activity : Activity) :
    RecyclerView.Adapter<LivroAdapter.LivroViewHolder>(){
    var listaLivros = livros
    var activityPrincipal = activity

    class LivroViewHolder(itemView: View, activity: Activity, listaLivros : List<LivroComAutor>) : RecyclerView.ViewHolder(itemView){

        var nomeLivro = itemView.findViewById<TextView>(R.id.lst_nome_livro)
        var nomeAutor = itemView.findViewById<TextView>(R.id.lst_autor_livro)

        var detalheLivro = itemView!!.findViewById<ImageButton>(R.id.visualiza_livro).setOnClickListener{
            var livroSelecionado = listaLivros[adapterPosition]
            var texto = Gson().toJson(livroSelecionado)

            var intentDetalheLivro = Intent(activity,AtualizarLivroActivity::class.java)
            intentDetalheLivro.putExtra("livro", texto)
            activity.startActivity(intentDetalheLivro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_livro, parent, false)

        return LivroViewHolder(card,activityPrincipal,listaLivros)
    }

    override fun getItemCount() = listaLivros.size

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {

        holder.nomeAutor.text = listaLivros[position].autor.nome
        holder.nomeLivro.text = listaLivros[position].livro.titulo
    }
}