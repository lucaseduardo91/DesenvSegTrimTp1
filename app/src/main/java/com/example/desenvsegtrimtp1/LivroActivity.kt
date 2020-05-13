package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desenvsegtrimtp1.models.Livro
import com.example.desenvsegtrimtp1.repository.AutorRepository
import com.example.desenvsegtrimtp1.repository.LivroRepository
import kotlinx.android.synthetic.main.activity_livro.*

class LivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livro)

        btn_criar_livro.setOnClickListener {
            criarLivroNoBanco()
        }

        btn_listar_livros.setOnClickListener {
            if(LivroRepository.listarLivros().isNullOrEmpty())
                Toast.makeText(this,"Nenhum livro cadastrado. Crie pelo menos um!", Toast.LENGTH_LONG).show()
            else
            {
                var intent = Intent(this,ListaLivrosActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun criarLivroNoBanco()
    {
        if(!input_nome_livro.toString().isNullOrBlank() && !input_autor_criar_livro.toString().isNullOrBlank())
        {
            var autor = AutorRepository.buscarPeloNome(input_autor_criar_livro.toString())
            if(autor != null)
            {
                var livro = Livro(null,input_nome_livro.toString(),autor.id!!)
                LivroRepository.inserirLivro(livro)

                Toast.makeText(this,"Autor inserido!", Toast.LENGTH_LONG).show()

                var intent = Intent(this,ListaLivrosActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
