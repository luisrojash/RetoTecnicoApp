package com.app.lerp.data.remote.comments

import com.app.lerp.core.model.EventResult
import com.app.lerp.data.remote.util.validateResponse
import com.app.lerp.data.response.toEntity
import com.app.lerp.entity.CommentsEntity
import com.app.lerp.entity.PostEntity
import com.app.lerp.usecase.repository.comments.RemoteCommentsRepository

class CommentsRemote(private val api: CommentsApi) : RemoteCommentsRepository {


    override suspend fun getComments(post: PostEntity): EventResult<List<CommentsEntity>> {
        return api.getPostAndComents(post.id).validateResponse {
            this.map { it.toEntity() }
        }
    }


}