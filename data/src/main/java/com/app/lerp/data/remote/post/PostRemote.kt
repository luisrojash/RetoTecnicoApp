package com.app.lerp.data.remote.post

import com.app.lerp.core.model.EventResult
import com.app.lerp.data.remote.util.validateResponse
import com.app.lerp.data.response.toEntity
import com.app.lerp.entity.PostEntity
import com.app.lerp.usecase.repository.post.RemotePostRepository

class PostRemote(private val api: PostApi) : RemotePostRepository {

    override suspend fun getListPost(): EventResult<List<PostEntity>> {
        return api.getPostList().validateResponse {
            this.map { it.toEntity() }
        }
    }
}