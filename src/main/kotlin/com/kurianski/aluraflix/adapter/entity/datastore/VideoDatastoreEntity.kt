package com.kurianski.aluraflix.adapter.entity.datastore

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.util.*

@Document(indexName = "videos")
data class VideoDatastoreEntity(
    @Id
    val id: UUID,
    val titulo: String,
    val descricao: String,
    val url: String
)