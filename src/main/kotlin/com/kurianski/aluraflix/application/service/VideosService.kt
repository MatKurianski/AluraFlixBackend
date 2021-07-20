package com.kurianski.aluraflix.application.service

import com.kurianski.aluraflix.adapter.mapper.toVideo
import com.kurianski.aluraflix.application.datastore.VideosRepository
import com.kurianski.aluraflix.domain.CreateVideoRequest
import com.kurianski.aluraflix.domain.Video
import org.springframework.stereotype.Service
import java.util.*

@Service
class VideosService(private val videosRepository: VideosRepository) {
    fun getById(id: UUID): Result<Video> = videosRepository.getById(id)

    fun getAll(): Result<List<Video>> = videosRepository.getAll()

    fun createVideo(createVideoRequest: CreateVideoRequest): Result<Video> {
        val video = createVideoRequest.toVideo(UUID.randomUUID())
        return updateVideo(video)
    }

    fun updateVideo(video: Video): Result<Video> = videosRepository.put(video)

    fun removeVideoById(id: UUID): Result<Boolean> = videosRepository.removeById(id)
}