package com.glb.training.bookstorems.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.glb.training.bookstorems.clients.RatingClient;
import com.glb.training.bookstorems.dto.BookDTO;
import com.glb.training.bookstorems.dto.RatingDTO;
import com.glb.training.bookstorems.model.Book;
import com.glb.training.bookstorems.repository.BookRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Slf4j
@RestController
public class BookRestController {

	private final BookRepository bookRepository;
	private final RatingClient ratingClient;

	private final String welcome;

	@Autowired
	public BookRestController(BookRepository bookRepository, RatingClient ratingClient,
			@Value("${bookstore.message:hello world}") String welcome) {
		super();
		this.bookRepository = bookRepository;
		this.ratingClient = ratingClient;
		this.welcome = welcome;
	}

	@GetMapping("/info")
	public String getDiscoveryClientInfo() throws UnknownHostException {
		log.debug("Discovery Client Info");

		return welcome + "Service Instance deployed on: ########### " + InetAddress.getLocalHost().getHostAddress();
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		log.debug("Getting all books");
		return bookRepository.findAll();
	}

	@HystrixCommand(fallbackMethod = "getBooksDetailsFallback")
	@GetMapping("/book/detail/{bookId}")
	public ResponseEntity<BookDTO> getBooksDetails(@PathVariable final Long bookId) {
		log.debug("Getting book detail {}", bookId);
		RatingDTO findBookRating = ratingClient.findBookRating(bookId);
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		BookDTO bookDTO = bookOpt.map(book -> BookDTO.builder().author(book.getAuthor()).id(book.getId())
				.isbn(book.getIsbn()).name(book.getName()).rating(findBookRating).build()).get();
		return ResponseEntity.of(Optional.ofNullable(bookDTO));
	}
	
	public ResponseEntity<BookDTO> getBooksDetailsFallback(@PathVariable final Long bookId) {
		log.debug("Getting book detail fallback {}", bookId);
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		BookDTO bookDTO = bookOpt.map(book -> BookDTO.builder().author(book.getAuthor()).id(book.getId())
				.isbn(book.getIsbn()).name(book.getName()).build()).get();
		return ResponseEntity.of(Optional.ofNullable(bookDTO));
	}

	@GetMapping("/book/{isbn}")
	public Book getBookByIsbn(@PathVariable final String isbn) {
		log.debug("Searching for the book {}", isbn);
		return bookRepository.findByIsbn(isbn);
	}

}
