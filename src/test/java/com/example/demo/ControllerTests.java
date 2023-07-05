package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.models.Contact;
import com.example.demo.services.ContactService;

@WebMvcTest
class ControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	@Qualifier("DB")
	private ContactService contactService;

	@Test
	void getShouldReturnEmptyListFromService() throws Exception {
		when(contactService.getContacts()).thenReturn(new ArrayList<Contact>());
		this.mockMvc.perform(get("/api/contact/")).andExpect(status().isOk()).andExpect(content().string("[]"));
	}

	@Test
	void insertShouldReturn0() throws Exception {
		when(contactService.insertContact(new Contact())).thenReturn(0);
		this.mockMvc
			.perform(
				post("/api/contact/insert")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"John\",\"phone\": \"+09876543221\"}")
			)
			.andExpect(status().isOk())
			.andExpect(content().string("0"));
	}

	@Test
	void updateShouldReturn0() throws Exception {
		when(contactService.updateContactById(UUID.randomUUID(), new Contact())).thenReturn(0);
		this.mockMvc
			.perform(
				put("/api/contact/update/"+UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"John2\",\"phone\": \"+09871\"}")
			)
			.andExpect(status().isOk())
			.andExpect(content().string("0"));
	}

	@Test
	void deleteShouldReturn0() throws Exception {
		when(contactService.deleteContactById(UUID.randomUUID())).thenReturn(0);
		this.mockMvc
			.perform(delete("/api/contact/delete/"+UUID.randomUUID()))
			.andExpect(status().isOk())
			.andExpect(content().string("0"));
	}
}
