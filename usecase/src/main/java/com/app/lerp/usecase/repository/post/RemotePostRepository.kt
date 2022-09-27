package com.app.lerp.usecase.repository.post

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.PostEntity

interface RemotePostRepository {

    suspend fun getListPost(): EventResult<List<PostEntity>>

}