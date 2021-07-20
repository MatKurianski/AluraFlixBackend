package com.kurianski.aluraflix.adapter.controller

import com.kurianski.aluraflix.adapter.entity.rest.DefaultResponse
import com.kurianski.aluraflix.adapter.mapper.toErrorResponse
import com.kurianski.aluraflix.adapter.mapper.toVideo
import com.kurianski.aluraflix.application.service.VideosService
import com.kurianski.aluraflix.domain.CreateVideoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/videos")
class VideosController(private val videosService: VideosService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID) =
        videosService.getById(id).fold(
            onSuccess = { ResponseEntity.ok(it) },
            onFailure = { it.toErrorResponse() }
        )

    @GetMapping
    fun getAll(): ResponseEntity<Any> =
        videosService.getAll().fold(
            onSuccess = { ResponseEntity.ok(it) },
            onFailure = { it.toErrorResponse() }
        )

    @PostMapping
    fun create(@RequestBody @Valid createVideoRequest: CreateVideoRequest): ResponseEntity<Any> {
        val result = videosService.createVideo(createVideoRequest)

        return result.fold(
            onSuccess = { ResponseEntity.ok().body(it) },
            onFailure = { it.toErrorResponse() }
        )
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    fun update(@RequestBody createVideoRequest: CreateVideoRequest, @PathVariable id: UUID): ResponseEntity<Any> {
        val video = createVideoRequest.toVideo(id)
        val result = videosService.updateVideo(video)

        return result.fold(
            onSuccess = { ResponseEntity.ok().body(it) },
            onFailure = { it.toErrorResponse() }
        )
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Any> =
        videosService.removeVideoById(id).fold(
            onSuccess = { ResponseEntity.ok(DefaultResponse("Deletado com sucesso")) },
            onFailure = { ResponseEntity.internalServerError().body(DefaultResponse("Não foi possível deletar")) }
        )
}