package com.app.lerp.retotecnicoapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.lerp.core.extension.launchOnIO
import com.app.lerp.retotecnicoapp.base.BaseViewModel
import com.app.lerp.retotecnicoapp.ui.fragment.PostEventResult
import com.app.lerp.usecase.usecase.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
   // @ApplicationContext private val context: Context
): BaseViewModel () {

    private val _postLiveData: MutableLiveData<PostEventResult> = MutableLiveData()
    val postLiveData: LiveData<PostEventResult> get() = _postLiveData



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
}