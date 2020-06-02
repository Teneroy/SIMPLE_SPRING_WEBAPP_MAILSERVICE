package org.example.microservices.mail.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Configuration
class MailConfig {
    @Value("\${spring.mail.host}")
    lateinit var host: String

    @Value("\${spring.mail.username}")
    lateinit var username: String

    @Value("\${spring.mail.password}")
    lateinit var password: String

    @Value("\${spring.mail.port}")
    lateinit var port: Number

    @Value("\${spring.mail.protocol}")
    lateinit var protocol: String

    @Value("\${mail.debug}")
    lateinit var debug: String

    @Bean
    fun getMailSender(): JavaMailSender {
        val mailSender: JavaMailSenderImpl = JavaMailSenderImpl()

        mailSender.host = host
        mailSender.port = port.toInt()
        mailSender.username = username
        mailSender.password = password

        val properties: Properties = mailSender.javaMailProperties

        properties.setProperty("mail.transport.protocol", protocol)
        properties.setProperty("mail.debug", debug)

        return mailSender
    }
}