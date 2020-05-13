package com.example.desenvsegtrimtp1.dao

import androidx.room.*
import com.example.desenvsegtrimtp1.models.Livro
import com.example.desenvsegtrimtp1.models.LivroComAutor

@Dao
interface LivroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg livro: Livro)

    @Update
    fun update(vararg livro: Livro)

    @Delete
    fun delete(vararg livro: Livro)

    @Query("SELECT * FROM livro")
    fun all() : Array<Livro>

    @Query("SELECT * FROM livro WHERE id = :id")
    fun show(id : Int) : Livro

    @Query("SELECT * FROM livro")
    fun livrosComAutores() : Array<LivroComAutor>
}