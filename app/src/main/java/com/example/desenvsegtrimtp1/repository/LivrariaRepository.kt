package com.example.desenvsegtrimtp1.repository

import android.content.Context
import com.example.desenvsegtrimtp1.models.Livro

class LivrariaRepository {

    companion object{
        private var repository : LivrariaRepository? = null
        private lateinit var contexto : Context

        fun getInstance(context: Context): LivrariaRepository{
            if(repository == null) {
                repository = LivrariaRepository()
                contexto = context
            }
            return repository as LivrariaRepository
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

    }

}