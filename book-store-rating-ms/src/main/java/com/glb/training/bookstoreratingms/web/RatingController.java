package com.glb.training.bookstoreratingms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.glb.training.bookstoreratingms.model.Rating;
import com.glb.training.bookstoreratingms.repository.RatingRepository;

@RestController
public class RatingController {
	
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@GetMapping(path = "/rating/book/{id}")
	public ResponseEntity<Rating> findRatingByBook(@PathVariable final Long id) {
		return ResponseEntity.of(ratingRepository.findById(id));
	}

}
