package com.example.desenvsegtrimtp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desenvsegtrimtp1.models.Autor
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
            AtualizarAutorNoBanco(autor)
        }

        btn_deletar_autor.setOnClickListener {
            DeletarAutorNoBanco(autor)
        }
    }

    fun AtualizarAutorNoBanco(autor: Autor)
    {

    }

    fun DeletarAutorNoBanco(autor: Autor)
    {

    }
}
