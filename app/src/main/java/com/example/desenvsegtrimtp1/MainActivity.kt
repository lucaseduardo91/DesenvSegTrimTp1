package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desenvsegtrimtp1.repository.AutorRepository
import com.example.desenvsegtrimtp1.services.ExportarDadosAsync
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navegar_para_autores.setOnClickListener {
            var intent = Intent(this,AutorActivity::class.java)
            startActivity(intent)
        }

        navegar_livros_main.setOnClickListener {
            var intent = Intent(this,LivroActivity::class.java)
            startActivity(intent)
        }

        exportarDados.setOnClickListener {
            Toast.makeText(this,"Verificando os dados para exportar...", Toast.LENGTH_LONG).show()
            var task = ExportarDadosAsync(this).execute()
        }
    }
}
