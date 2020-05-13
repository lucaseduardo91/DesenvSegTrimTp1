package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desenvsegtrimtp1.models.Livro
import com.example.desenvsegtrimtp1.models.LivroComAutor
import com.example.desenvsegtrimtp1.repository.AutorRepository
import com.example.desenvsegtrimtp1.repository.LivroRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_atualizar_livro.*

class AtualizarLivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_livro)

        var livroTexto = intent.getStringExtra("livro")
        var livro = Gson().fromJson<LivroComAutor>(livroTexto,Livro::class.java)

        input_atlz_nome_livro.setText(livro.livro.titulo)
        nome_autor_atlz_livro.setText(livro.autor.nome)

        btn_atlz_livro.setOnClickListener {
            atualizarLivroNoBanco()
        }

        btn_deletar_livro.setOnClickListener {
            deletarLivroNoBanco(livro)
        }
    }

    fun atualizarLivroNoBanco()
    {
        if(!nome_autor_atlz_livro.text.toString().isNullOrBlank())
        {
            var autor = AutorRepository.buscarPeloNome(nome_autor_atlz_livro.text.toString())
            if(autor != null)
            {
                if(!input_atlz_nome_livro.text.toString().isNullOrBlank())
                {
                    var livro = Livro(null,input_atlz_nome_livro.text.toString(),autor.id!!)
                    LivroRepository.atualizarLivro(livro)

                    var intent = Intent(this,ListaLivrosActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"Preencha corretamente o campo nome do livro!",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this,"Autor não cadastrado!",Toast.LENGTH_LONG).show()
            }

        }
        else
        {
            Toast.makeText(this,"Preencha corretamente o campo nome do autor!",Toast.LENGTH_LONG).show()
        }

    }

    fun deletarLivroNoBanco(livroComAutor: LivroComAutor)
    {
        LivroRepository.deletarLivro(livroComAutor.livro.id)

        var intent = Intent(this,ListaLivrosActivity::class.java)
        startActivity(intent)
    }
}
