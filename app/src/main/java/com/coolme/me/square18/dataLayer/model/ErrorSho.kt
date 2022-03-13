package com.coolme.me.square18.dataLayer.model

import javax.inject.Inject

class ErrorSho @Inject constructor(
    error : Boolean,
    statusCode : Int,
    message : String,
    title : String? = null,
    type: String?,
                                  )
    : Error()
