package com.app.lerp.data.response

import com.app.lerp.entity.CommentsEntity
import com.google.gson.annotations.SerializedName


data class CommentsResponse(
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
)


fun CommentsResponse.toEntity() = CommentsEntity(
    id = id,
    postId = postId,
    body = body,
    name = name,
    email = email
)
