package com.kurianski.aluraflix.adapter.mapper

import com.kurianski.aluraflix.adapter.entity.datastore.VideoDatastoreEntity
import com.kurianski.aluraflix.domain.CreateVideoRequest
import com.kurianski.aluraflix.domain.Video
import java.util.*

fun Video.toDatastoreEntity() =
    VideoDatastoreEntity(
        id,
        titulo,
        descricao,
        url
    )

fun VideoDatastoreEntity.toVideo() =
    Video(
        id,
        titulo,
        descricao,
        url
    )

fun CreateVideoRequest.toVideo(id: UUID) =
    Video(
        id,
        titulo,
        descricao,
        url
    )
