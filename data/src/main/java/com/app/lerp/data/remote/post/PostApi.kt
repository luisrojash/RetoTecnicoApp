package com.app.lerp.data.remote.post

import com.app.lerp.data.response.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPostList(): Response<List<PostResponse>>
}