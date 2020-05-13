package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desenvsegtrimtp1.adapters.LivroAdapter
import com.example.desenvsegtrimtp1.repository.LivroRepository
import kotlinx.android.synthetic.main.activity_lista_livros.*

class ListaLivrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_livros)

        btn_voltar_livro.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        configurarRecyclerView()
    }

    fun configurarRecyclerView(){
        listagem_livros.layoutManager = LinearLayoutManager(this)
        listagem_livros.adapter = LivroAdapter(LivroRepository.getInstance(this.applicationContext).listarLivrosComAutores().toList(),this)
    }
}
