package org.example.microservices.mail.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mail")
class MainController {

    @PostMapping("/send")
    fun sendEmail(to: String, title: String, text: String): String {


        return ""
    }
}