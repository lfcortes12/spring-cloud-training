package com.glb.training.bookstorems.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.glb.training.bookstorems.model.Book;
import com.glb.training.bookstorems.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookRestController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/info")
	public String getDiscoveryClientInfo() {
		log.debug("Discovery Client Info");

		return "Service Instance: " + discoveryClient.getServices().toString();
	}

	@GetMapping("/book/{isbn}")
	public Book getBookByIsbn(@PathVariable final String isbn) {
		log.debug("Searching for the book {}", isbn);
		return bookRepository.findByIsbn(isbn);
	}

}
