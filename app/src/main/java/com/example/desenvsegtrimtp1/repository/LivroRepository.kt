package com.example.desenvsegtrimtp1.repository

import android.content.Context
import com.example.desenvsegtrimtp1.models.Livro
import com.example.desenvsegtrimtp1.models.LivroComAutor

class LivroRepository {

    companion object{
        private var repository : LivroRepository? = null
        private lateinit var contexto : Context

        fun getInstance(context: Context): LivroRepository{
            if(repository == null) {
                repository = LivroRepository()
                contexto = context
            }
            return repository as LivroRepository
        }

        fun inserirLivro(livro: Livro){
            LivrariaDatabase.getInstance(contexto).livroDao().insert(livro)
        }

        fun deletarLivro(livro: Livro){
            LivrariaDatabase.getInstance(contexto).livroDao().delete(livro)
        }

        fun atualizarLivro(livro: Livro){
            LivrariaDatabase.getInstance(contexto).livroDao().update(livro)
        }

        fun listarLivros() : Array<Livro>{
            return LivrariaDatabase.getInstance(contexto).livroDao().all()
        }

        fun detalharLivro(id : Int) : Livro{
            return LivrariaDatabase.getInstance(contexto).livroDao().show(id)
        }

        fun listarLivrosComAutores() : Array<LivroComAutor>{
            return LivrariaDatabase.getInstance(contexto).livroDao().livrosComAutores()
        }

    }

}