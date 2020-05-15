package com.example.desenvsegtrimtp1.services

import android.content.Context
import java.io.File

class EscreverNoArquivo{
    companion object{
        private var escreverNoArquivo : EscreverNoArquivo? = null
        private lateinit var contexto : Context

        fun getInstance(context: Context): EscreverNoArquivo{
            if(escreverNoArquivo == null)
            {
                escreverNoArquivo = EscreverNoArquivo()
                contexto = context
            }

            return escreverNoArquivo as EscreverNoArquivo
        }
    }

    fun escrever(texto : String, context: Context){

        var file = File(context.filesDir, "livrariaDados.txt")

        if(!file.exists())
            file.createNewFile()

        if(file.canWrite())
        {
            file.writeText(texto)
        }
        var i = 0
    }
}