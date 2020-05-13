package com.example.desenvsegtrimtp1.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.desenvsegtrimtp1.dao.AutorDao
import com.example.desenvsegtrimtp1.dao.LivroDao
import com.example.desenvsegtrimtp1.models.Autor
import com.example.desenvsegtrimtp1.models.Livro

@Database(
    entities = arrayOf(Autor::class,Livro::class),
    version = 1
)
abstract class LivrariaDatabase : RoomDatabase(){

    abstract fun autorDao() : AutorDao
    abstract fun livroDao() : LivroDao

    companion object {
        private var livrariaDatabase: LivrariaDatabase? = null
        fun getInstance(context: Context): LivrariaDatabase {
            if (livrariaDatabase == null) {
                livrariaDatabase = Room.databaseBuilder(
                    context,
                    LivrariaDatabase::class.java,
                    "livrariaDatabase.db"
                ).allowMainThreadQueries()
                .build()
            }
            return livrariaDatabase!!
        }
    }
}