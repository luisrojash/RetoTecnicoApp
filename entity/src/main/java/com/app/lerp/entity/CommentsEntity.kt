package com.app.lerp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CommentsEntity(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
) : Parcelable
