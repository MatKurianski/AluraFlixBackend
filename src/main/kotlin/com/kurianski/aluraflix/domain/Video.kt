package com.kurianski.aluraflix.domain

import java.util.*

data class Video(
    val id: UUID,
    val titulo: String,
    val descricao: String,
    val url: String
)
