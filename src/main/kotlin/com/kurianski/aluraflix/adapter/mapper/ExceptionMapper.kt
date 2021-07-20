package com.kurianski.aluraflix.adapter.mapper

import com.kurianski.aluraflix.adapter.entity.rest.DefaultResponse
import com.kurianski.aluraflix.domain.exception.VideoNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun Throwable.toErrorResponse(): ResponseEntity<Any> =
    when(this) {
        is VideoNotFoundException -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultResponse("Não encontrado"))
        else -> ResponseEntity.internalServerError().build()
    }
