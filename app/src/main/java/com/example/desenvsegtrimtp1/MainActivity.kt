package com.example.desenvsegtrimtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
