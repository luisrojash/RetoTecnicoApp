package com.app.lerp.entity

data class PostEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    val email: String? = null
)