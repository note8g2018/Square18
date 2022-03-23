package com.coolme.me.square18.dataLayer.model

sealed class ResultSho<out T>
{
    data class Success<T>(val data: T) : ResultSho<T>()
    data class Failure(val errorSho: ErrorSho) : ResultSho<Nothing>()
    object Progressing : ResultSho<Nothing>()
}
