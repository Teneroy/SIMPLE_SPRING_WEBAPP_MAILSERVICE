package org.example.microservices.mail.domain.dto

data class ResponseDto(
        var from: String = "",
        var to: String = "",
        var title: String = "",
        var text: String = "",
        var success: Boolean = true,
        var error: String = ""
)