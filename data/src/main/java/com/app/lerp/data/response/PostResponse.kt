package com.app.lerp.data.response

import com.app.lerp.entity.PostEntity
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)


fun PostResponse.toEntity() = PostEntity(
    id = id,
    title = title,
    body = body,
    userId = userId
)
