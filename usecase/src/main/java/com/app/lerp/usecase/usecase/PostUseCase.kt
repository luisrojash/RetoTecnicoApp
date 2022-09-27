package com.app.lerp.usecase.usecase

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.PostEntity
import com.app.lerp.usecase.repository.post.LocalPostRepository
import com.app.lerp.usecase.repository.post.RemotePostRepository
import javax.inject.Inject

class PostUseCase @Inject constructor(
    private val postRemote: RemotePostRepository
) {

    suspend fun getListPost(): EventResult<List<PostEntity>> {
        val result = postRemote.getListPost()
        return result
    }

}