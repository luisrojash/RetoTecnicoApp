package com.app.lerp.retotecnicoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.lerp.core.extension.launchOnIO
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.base.BaseViewModel
import com.app.lerp.retotecnicoapp.ui.fragment.event.CommentsEventResult
import com.app.lerp.retotecnicoapp.ui.fragment.event.PostEventResult
import com.app.lerp.usecase.usecase.CommentsUseCase
import com.app.lerp.usecase.usecase.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    private val commentsUseCase: CommentsUseCase,
   // @ApplicationContext private val context: Context
): BaseViewModel () {

    private val _postLiveData: MutableLiveData<PostEventResult> = MutableLiveData()
    val postLiveData: LiveData<PostEventResult> get() = _postLiveData

    private val _postComentsLiveData: MutableLiveData<CommentsEventResult> = MutableLiveData()
    val postComentLiveData: LiveData<CommentsEventResult> get() = _postComentsLiveData

    fun getListPost() {
        launchOnIO(
            doTask = {
                postUseCase.getListPost()
            },
            result = {
                _postLiveData.postValue(PostEventResult.ShowListPost(it))
            },
            error = {
                _postLiveData.postValue(PostEventResult.Error(it))
            }
        )
    }

    fun getPostAndComents(postParcel: PostEntity) {
        launchOnIO(
            doTask = {
                commentsUseCase.getPostAndComents(postParcel)
            },
            result = {
                _postComentsLiveData.postValue(CommentsEventResult.ShowListComments(it))
            },
            error = {
                _postComentsLiveData.postValue(CommentsEventResult.Error(it))
            }
        )
    }

}