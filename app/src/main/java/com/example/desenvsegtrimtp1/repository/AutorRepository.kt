package com.example.desenvsegtrimtp1.repository

import android.content.Context
import com.example.desenvsegtrimtp1.models.Autor

class AutorRepository {

    companion object{
        private var repository : AutorRepository? = null
        private lateinit var contexto : Context

        fun getInstance(context: Context): AutorRepository{
            if(repository == null) {
                repository = AutorRepository()
                contexto = context
            }
            return repository as AutorRepository
        }

    }

    fun inserirAutor(autor: Autor){
        LivrariaDatabase.getInstance(contexto).autorDao().insert(autor)
    }

    fun deletarAutor(id: Int){
        LivrariaDatabase.getInstance(contexto).autorDao().delete(id)
    }

    fun atualizarAutor(autor: Autor){
        LivrariaDatabase.getInstance(contexto).autorDao().update(autor)
    }

    fun listarAutores() : Array<Autor>{
        return LivrariaDatabase.getInstance(contexto).autorDao().all()
    }

    fun detalharAutor(id : Int) : Autor {
        return LivrariaDatabase.getInstance(contexto).autorDao().show(id)
    }

    fun buscarPeloNome(nome : String) : Autor?{
        return LivrariaDatabase.getInstance(contexto).autorDao().search(nome)
    }

    fun deletarTudo(){
        LivrariaDatabase.getInstance(contexto).autorDao().deleteAll()
    }
}