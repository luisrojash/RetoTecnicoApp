package com.app.lerp.core.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.lerp.core.BuildConfig
import com.app.lerp.core.model.EventResult
import kotlinx.coroutines.*


typealias DoTask<T> = suspend CoroutineScope.() -> EventResult<T>
typealias SuccessResult<T> = (success: T) -> Unit
typealias ErrorResult = ((Exception) -> Unit)?
typealias Finally = (() -> Unit)?
typealias SuccessResultCancelable<T> = (success: T, isActive: Boolean) -> Unit
typealias ErrorResultCancelable = ((Exception, isActive: Boolean) -> Unit)?

fun <T> ViewModel.launchOnIO(
    doTask: DoTask<T>,
    result: SuccessResult<T>,
    error: ErrorResult = null,
    finally: Finally = null
): Job {
    return viewModelScope.launch {
        try {
            withContext(Dispatchers.IO) {
                doTask()
            }.also {
                when (it) {
                    is EventResult.Success -> result(it.value)
                    is EventResult.Error -> error?.invoke(it.exception)
                }
            }
        } catch (ex: Exception) {
            if (BuildConfig.DEBUG) {
                println("Ocurrió un error")
                ex.printStackTrace()
            }
            error?.invoke(ex)
        } finally {
            finally?.invoke()
        }
    }
}
