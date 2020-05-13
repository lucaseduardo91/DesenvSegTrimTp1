package com.example.desenvsegtrimtp1.models

import androidx.room.Embedded
import androidx.room.Relation

data class LivroComAutor (
    @Embedded val autor: Autor,
    @Relation(
        parentColumn = "id",
        entityColumn = "autorId"
    )
    val livro: Livro
)