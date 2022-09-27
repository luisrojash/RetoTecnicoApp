package com.app.lerp.usecase.usecase

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.CommentsEntity
import com.app.lerp.entity.PostEntity
import com.app.lerp.usecase.repository.comments.RemoteCommentsRepository
import com.app.lerp.usecase.repository.post.RemotePostRepository
import javax.inject.Inject

class CommentsUseCase @Inject constructor(
    private val commentsRepository: RemoteCommentsRepository
) {

    suspend fun getPostAndComents(postEntity: PostEntity): EventResult<List<CommentsEntity>> {
        return commentsRepository.getComments(postEntity)
    }
}