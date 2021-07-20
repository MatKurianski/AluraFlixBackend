package com.kurianski.aluraflix.adapter.datastore

import com.kurianski.aluraflix.adapter.entity.datastore.VideoDatastoreEntity
import com.kurianski.aluraflix.adapter.mapper.toDatastoreEntity
import com.kurianski.aluraflix.adapter.mapper.toVideo
import com.kurianski.aluraflix.application.datastore.VideosRepository
import com.kurianski.aluraflix.domain.Video
import com.kurianski.aluraflix.domain.exception.VideoNotFoundException
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.elasticsearch.core.query.Query
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException
import java.util.*

@Repository
class VideosElasticSearchRepository(private val elasticsearchRestTemplate: ElasticsearchRestTemplate) : VideosRepository {

    override fun getById(id: UUID): Result<Video> =
        runCatching {
            elasticsearchRestTemplate.get(id.toString(), VideoDatastoreEntity::class.java)?.toVideo()
                ?: throw VideoNotFoundException()
        }

    override fun put(video: Video): Result<Video> =
        runCatching {
            val videoDatastoreEntity = video.toDatastoreEntity()
            elasticsearchRestTemplate.save(videoDatastoreEntity).toVideo()
        }

    override fun getAll(): Result<List<Video>> {
        val query: Query = NativeSearchQueryBuilder()
                            .withQuery(QueryBuilders.matchAllQuery())
                            .build()

        return runCatching {
            elasticsearchRestTemplate.search(query, VideoDatastoreEntity::class.java)
                .map { it.content }
                .map { it.toVideo() }
                .toList()
        }
    }

    override fun removeById(id: UUID): Result<Boolean> =
        runCatching{ elasticsearchRestTemplate.delete(id.toString(), VideoDatastoreEntity::class.java) }
            .map { true }
}