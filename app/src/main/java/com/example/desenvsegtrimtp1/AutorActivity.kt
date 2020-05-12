package com.example.desenvsegtrimtp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desenvsegtrimtp1.models.Autor
import kotlinx.android.synthetic.main.activity_autor.*

class AutorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autor)

        btn_criar_autor.setOnClickListener {
            CriarAutorNoBanco()
        }
        
    }

    fun CriarAutorNoBanco()
    {
        var autor : Autor = Autor(null,input_nome_autor.text.toString(),input_nacionalidade_autor.text.toString())
        // Chamar método de criação no banco
    }
}
