package com.app.lerp.retotecnicoapp.ui.fragment.event

import com.app.lerp.entity.CommentsEntity

sealed class CommentsEventResult {
    data class ShowListComments(val data: List<CommentsEntity>) : CommentsEventResult()
    data class Error(val ex: Exception) : CommentsEventResult()
}