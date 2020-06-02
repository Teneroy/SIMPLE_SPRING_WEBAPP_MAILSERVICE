package org.example.microservices.mail

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class MailApplicationTests {
	@Autowired
	private lateinit var mockMvc: MockMvc

	@Value("\${testadress}")
	private lateinit var addressTo: String

	@Value("\${spring.mail.username}")
	private lateinit var addressFrom: String

	@Test
	fun sendEmailTest() {
		this.mockMvc.perform(post("/mail/send")
				.param("to", addressTo).param("title", "Test title").param("text", "Test text"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk)
				.andExpect(jsonPath("$.from").value(addressFrom))
				.andExpect(jsonPath("$.to").value(addressTo))
				.andExpect(jsonPath("$.success").value("true"))
				.andExpect(jsonPath("$.error").value(""))
				.andExpect(jsonPath("$.title").value("Test title"))
				.andExpect(jsonPath("$.text").value("Test text"))
	}

}
