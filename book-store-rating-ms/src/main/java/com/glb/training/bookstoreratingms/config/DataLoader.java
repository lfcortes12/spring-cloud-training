package com.glb.training.bookstoreratingms.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.glb.training.bookstoreratingms.model.Rating;
import com.glb.training.bookstoreratingms.repository.RatingRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final RatingRepository ratingRepository;
	
	@Autowired
	public DataLoader(RatingRepository ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		log.info("Loading data on init ");
		List<Rating> ratings = Stream.of(Rating.builder().bookId(1L).value(5L).build()).collect(Collectors.toList());
		ratingRepository.saveAll(ratings);
	}

}
