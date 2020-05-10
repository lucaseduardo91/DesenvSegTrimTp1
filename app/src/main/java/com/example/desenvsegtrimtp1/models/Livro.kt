package com.example.desenvsegtrimtp1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Livro (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val titulo: String,
    val autor: String
)