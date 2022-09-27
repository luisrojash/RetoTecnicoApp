package com.app.lerp.usecase.repository.comments

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.CommentsEntity
import com.app.lerp.entity.PostEntity

interface RemoteCommentsRepository {

    suspend fun getComments(commentsEntity: PostEntity): EventResult<List<CommentsEntity>>

}