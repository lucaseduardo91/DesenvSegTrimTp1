package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desenvsegtrimtp1.adapters.AutorAdapter
import com.example.desenvsegtrimtp1.repository.AutorRepository
import kotlinx.android.synthetic.main.activity_lista_autores.*

class ListaAutoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_autores)

        btn_voltar_autor.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        configurarRecyclerView()
    }

    fun configurarRecyclerView(){
        listagem_autores.layoutManager = LinearLayoutManager(this)
        listagem_autores.adapter = AutorAdapter(AutorRepository.getInstance(this.applicationContext).listarAutores().toList(),this)
    }
}
