package org.example.microservices.mail.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailSender {
    @Autowired
    lateinit var mailSender: JavaMailSender

    @Value("\${spring.mail.username}")
    lateinit var username: String

    fun send(emailTo: String, subject: String, message: String): Unit {
        val mailMessage: SimpleMailMessage = SimpleMailMessage()

        mailMessage.setFrom(username)
        mailMessage.setTo(emailTo)
        mailMessage.setSubject(subject)
        mailMessage.setText(message)

        mailSender.send(mailMessage)
    }
}