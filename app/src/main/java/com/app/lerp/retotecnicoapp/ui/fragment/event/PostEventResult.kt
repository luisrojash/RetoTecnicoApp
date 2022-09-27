package com.app.lerp.retotecnicoapp.ui.fragment.event

import com.app.lerp.entity.PostEntity

sealed class PostEventResult {
    data class ShowListPost(val data: List<PostEntity>) : PostEventResult()
    data class Error(val ex: Exception) : PostEventResult()
}