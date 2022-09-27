package com.app.lerp.data.remote.comments

import com.app.lerp.data.response.CommentsResponse
import com.app.lerp.data.response.PostResponse
import com.app.lerp.entity.PostEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentsApi {

    @GET("posts/{id}/comments")
    suspend fun getPostAndComents(@Path("id") id: Int): Response<List<CommentsResponse>>
}