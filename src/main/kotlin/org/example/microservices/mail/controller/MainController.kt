package org.example.microservices.mail.controller

import org.example.microservices.mail.config.MailConfig
import org.example.microservices.mail.domain.dto.ResponseDto
import org.example.microservices.mail.service.MailSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/mail")
class MainController {
    @Autowired
    private lateinit var mailSender: MailSender

    @Value("\${spring.mail.username}")
    lateinit var from: String

    @PostMapping("/send")
    fun sendEmail(to: String, title: String, text: String) : ResponseDto {
        val response = ResponseDto()

        try {
            mailSender.send(to, title, text)
        } catch (e: Exception) {
            response.success = false
            response.error = e.toString()
        } finally {
            response.to = to
            response.text = text
            response.title = title
            response.from = from
        }

        return response
    }
}