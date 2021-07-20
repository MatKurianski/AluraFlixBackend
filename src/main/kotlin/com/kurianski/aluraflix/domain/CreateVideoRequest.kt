package com.kurianski.aluraflix.domain

import javax.validation.constraints.NotBlank

data class CreateVideoRequest(
    @field:NotBlank
    val titulo: String,
    @field:NotBlank
    val descricao: String,
    @field:NotBlank
    val url: String
)
