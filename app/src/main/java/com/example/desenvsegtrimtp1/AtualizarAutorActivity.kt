package com.example.desenvsegtrimtp1

import android.content.Intent
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
            deletarAutorNoBanco(autor.id!!)
        }
    }

    fun atualizarAutorNoBanco(autorId: Int)
    {
        if(!nome_autor_atlz.toString().isNullOrBlank() && !nacionalidade_atlz.toString().isNullOrBlank())
        {
            var autor = Autor(autorId,nome_autor_atlz.text.toString(),nacionalidade_atlz.text.toString())
            AutorRepository.getInstance(this.applicationContext).atualizarAutor(autor)
            Toast.makeText(this,"Autor atualizado!", Toast.LENGTH_LONG).show()

            var intent = Intent(this,ListaAutoresActivity::class.java)
            startActivity(intent)
        }
        else
            Toast.makeText(this,"Preencha corretamente todos os campos!", Toast.LENGTH_LONG).show()

    }

    fun deletarAutorNoBanco(autorId: Int)
    {
        AutorRepository.getInstance(this.applicationContext).deletarAutor(autorId)
        Toast.makeText(this,"Autor deletado!", Toast.LENGTH_LONG).show()
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
