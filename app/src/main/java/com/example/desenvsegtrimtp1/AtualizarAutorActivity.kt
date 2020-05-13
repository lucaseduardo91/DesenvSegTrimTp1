package com.example.desenvsegtrimtp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desenvsegtrimtp1.models.Autor
import com.example.desenvsegtrimtp1.repository.AutorRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_atualizar_autor.*

class AtualizarAutorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_autor)

        var autorTexto = intent.getStringExtra("autor")
        var autor = Gson().fromJson<Autor>(autorTexto,Autor::class.java)

        nome_autor_atlz.setText(autor.nome)
        nacionalidade_atlz.setText(autor.nacionalidade)

        btn_atlz_autor.setOnClickListener {
            atualizarAutorNoBanco(autor.id!!)
        }

        btn_deletar_autor.setOnClickListener {
            deletarAutorNoBanco(autor)
        }
    }

    fun atualizarAutorNoBanco(autorId: Int)
    {
        if(!nome_autor_atlz.toString().isNullOrBlank() && !nacionalidade_atlz.toString().isNullOrBlank())
        {
            var autor = Autor(autorId,nome_autor_atlz.toString(),nacionalidade_atlz.toString())
            AutorRepository.atualizarAutor(autor)
        }
        else
            Toast.makeText(this,"Preencha corretamente todos os campos!", Toast.LENGTH_LONG).show()

    }

    fun deletarAutorNoBanco(autor: Autor)
    {
        AutorRepository.deletarAutor(autor.id!!)
    }
}
