package com.example.desenvsegtrimtp1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Livro (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    var titulo: String,
    var autor: String
)