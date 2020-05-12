package com.example.desenvsegtrimtp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desenvsegtrimtp1.models.Livro
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_atualizar_livro.*

class AtualizarLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_livro)

        var livroTexto = intent.getStringExtra("livro")
        var livro = Gson().fromJson<Livro>(livroTexto,Livro::class.java)

        input_atlz_nome_livro.setText(livro.titulo)
        nome_autor_atlz_livro.setText(livro.autor)

        btn_atlz_livro.setOnClickListener {
            AtualizarLivroNoBanco(livro)
        }

        btn_deletar_livro.setOnClickListener {
            DeletarLivroNoBanco(livro)
        }
    }

    fun AtualizarLivroNoBanco(livro : Livro)
    {

    }

    fun DeletarLivroNoBanco(livro : Livro)
    {

    }
}
