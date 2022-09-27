package com.app.lerp.data.remote.util

import android.util.Log
import com.app.lerp.core.BaseException
import com.app.lerp.core.model.EventResult
import retrofit2.Response


fun <T, R> Response<T>?.validateResponse(
    transform: T.() -> R,
): EventResult<R> {
    try {
        this?.let { response ->
            val errorBody: String? = response.errorBody()?.string()
            if (response.isSuccessful && errorBody.isNullOrEmpty()) {
                val responseBody: T? = response.body()
                return responseBody?.let { data ->
                    EventResult.Success(transform.invoke(data))
                } ?: kotlin.run {
                    Log.i(
                        "BaseResponse ",
                        "responseBody:: Error con codigo diferente de 200 "
                    )
                    EventResult.Error(BaseException.GeneralException())
                }
            } else {
                Log.i("BaseResponse ", "responseBody:: ERROROR")
                if (code() == 401) {
                    return EventResult.Error(BaseException.GeneralException(code().toString()))
                }
                Log.i("BaseResponse ", "responseBody:: responseBody   code()" + code())
                return EventResult.Error(BaseException.GeneralException("Ocurrio algun problema , Contactese personal"))
            }
        } ?: kotlin.run {
            Log.i("BaseResponse ", "responseBody:: ERROROR 2")
            return EventResult.Error(BaseException.GeneralException())
        }
    } catch (ex: Exception) {
        Log.i("BaseResponse ", "responseBody:: ERROROR 3")
        return EventResult.Error(BaseException.GeneralException())
    }
}


