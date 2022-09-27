package com.app.lerp.data.remote.post

import com.app.lerp.data.response.PostResponse
import com.app.lerp.entity.PostEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
    suspend fun getPostList(): Response<List<PostResponse>>
}