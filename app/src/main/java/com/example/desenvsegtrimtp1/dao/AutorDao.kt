package com.example.desenvsegtrimtp1.dao

import androidx.room.*
import com.example.desenvsegtrimtp1.models.Autor

@Dao
interface AutorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg autor: Autor)

    @Update
    fun update(vararg autor: Autor)

    @Delete
    fun delete(vararg autor: Autor)

    @Query("SELECT * FROM autor")
    fun all() : Array<Autor>

    @Query("SELECT * FROM autor WHERE id = :id")
    fun show(id : Int) : Autor
}