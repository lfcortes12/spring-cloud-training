package com.glb.training.bookstorems.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	private final DiscoveryClient discoveryClient;
	private final BookRepository bookRepository;

	private final String welcome;

	@Autowired
	public BookRestController(DiscoveryClient discoveryClient, BookRepository bookRepository,
			@Value("${bookstore.message}") String welcome) {
		super();
		this.discoveryClient = discoveryClient;
		this.bookRepository = bookRepository;
		this.welcome = welcome;
	}

	@GetMapping("/info")
	public String getDiscoveryClientInfo() {
		log.debug("Discovery Client Info");

		return welcome + "Service Instance: " + discoveryClient.getServices().toString();
	}

	@GetMapping("/book/{isbn}")
	public Book getBookByIsbn(@PathVariable final String isbn) {
		log.debug("Searching for the book {}", isbn);
		return bookRepository.findByIsbn(isbn);
	}

}
