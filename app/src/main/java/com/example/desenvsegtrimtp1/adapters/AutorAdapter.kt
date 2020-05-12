package com.example.desenvsegtrimtp1.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desenvsegtrimtp1.AtualizarAutorActivity
import com.example.desenvsegtrimtp1.R
import com.example.desenvsegtrimtp1.models.Autor
import com.google.gson.Gson

class AutorAdapter (autores : List<Autor>, activity : Activity) :
    RecyclerView.Adapter<AutorAdapter.AutorViewHolder>(){
    var listaAutores = autores
    var activityPrincipal = activity

    class AutorViewHolder(itemView: View,activity: Activity,listaAutores : List<Autor>) : RecyclerView.ViewHolder(itemView){

        var nomeAutor = itemView.findViewById<TextView>(R.id.card_nome_autor)
        var nacionalidade = itemView.findViewById<TextView>(R.id.card_nacionalidade)

        var detalheAutor = itemView!!.findViewById<ImageButton>(R.id.visualiza_autor).setOnClickListener{
            var autorSelecionado = listaAutores[adapterPosition]
            var texto = Gson().toJson(autorSelecionado)

            var intentDetalheAutor = Intent(activity,AtualizarAutorActivity::class.java)
            intentDetalheAutor.putExtra("autor",texto)
            activity.startActivity(intentDetalheAutor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutorViewHolder {
        val card = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_autor, parent, false)

        return AutorViewHolder(card,activityPrincipal,listaAutores)
    }

    override fun getItemCount() = listaAutores.size

    override fun onBindViewHolder(holder: AutorViewHolder, position: Int) {

        holder.nomeAutor.text = listaAutores[position].nome
        holder.nacionalidade.text = listaAutores[position].nacionalidade
    }
}