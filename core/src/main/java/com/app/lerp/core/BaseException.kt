package com.app.lerp.core

import java.io.IOException

sealed class BaseException(
    errorMessage: String
) : IOException(errorMessage) {

    data class GeneralException(
        var errorMessage: String = ConstantsCore.Error.Message.GENERAL_ERROR_MESSAGE,
    ) : BaseException(errorMessage)

}
