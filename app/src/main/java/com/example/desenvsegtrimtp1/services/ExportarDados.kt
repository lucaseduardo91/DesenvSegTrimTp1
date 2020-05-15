package com.example.desenvsegtrimtp1.services

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import com.example.desenvsegtrimtp1.repository.AutorRepository
import com.example.desenvsegtrimtp1.repository.LivroRepository

class ExportarDadosAsync (val context: Context)
    : AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg params: Unit?) {

        var autores  = AutorRepository.getInstance(context).listarAutores().toList()
        var livros = LivroRepository.getInstance(context).listarLivrosComAutores().toList()
        var texto : String

        if(!autores.isNullOrEmpty())
        {
            texto = "Autores:\n\n"
            for (autor in autores)
            {
                texto += "Nome do Autor: ${autor.nome}\n"
                texto += "Nacionalidade do autor: ${autor.nacionalidade}\n\n"
            }

            if(!livros.isNullOrEmpty())
            {
                texto += "Livros:\n\n"
                for (livro in livros)
                {
                    texto += "Título do livro: ${livro.livro.titulo}\n"
                    texto += "Autor do livro: ${livro.autor.nome}\n\n"
                }
            }

            EscreverNoArquivo.getInstance(context).escrever(texto,context)
        }

    }

}