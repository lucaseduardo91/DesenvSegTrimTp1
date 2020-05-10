package com.example.desenvsegtrimtp1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Autor (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nome: String,
    val nacionalidade: String
)