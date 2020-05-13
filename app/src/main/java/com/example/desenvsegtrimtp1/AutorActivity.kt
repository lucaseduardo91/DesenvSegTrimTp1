package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desenvsegtrimtp1.models.Autor
import com.example.desenvsegtrimtp1.repository.AutorRepository
import kotlinx.android.synthetic.main.activity_autor.*

class AutorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autor)

        btn_criar_autor!!.setOnClickListener {
            criarAutorNoBanco()
        }

        btn_listar_autores!!.setOnClickListener {
            if(AutorRepository.getInstance(this.applicationContext).listarAutores().isNullOrEmpty())
                Toast.makeText(this,"Nenhum autor cadastrado. Crie pelo menos um!", Toast.LENGTH_LONG).show()
            else
            {
                var intent = Intent(this,ListaAutoresActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun criarAutorNoBanco()
    {
        if(!input_nome_autor.text.toString().isNullOrBlank() && !input_nacionalidade_autor.text.toString().isNullOrBlank())
        {
            var autor : Autor = Autor(null,input_nome_autor.text.toString(),input_nacionalidade_autor.text.toString())
            AutorRepository.getInstance(this.applicationContext).inserirAutor(autor)
            Toast.makeText(this,"Autor inserido!", Toast.LENGTH_LONG).show()

            var intent = Intent(this,ListaAutoresActivity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Preencha corretamente todos os campos!", Toast.LENGTH_LONG).show()
        }

    }
}
