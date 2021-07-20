package com.kurianski.aluraflix.application.datastore

import com.kurianski.aluraflix.domain.Video
import java.util.*

interface VideosRepository {
    fun put(video: Video): Result<Video>
    fun getAll(): Result<List<Video>>
    fun getById(id: UUID): Result<Video>
    fun removeById(id: UUID): Result<Boolean>
}