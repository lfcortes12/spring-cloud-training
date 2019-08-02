package com.glb.training.bookstorems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookDTO {
	
	private final RatingDTO rating;
	private final Long id;
	private final String name;
	private final String isbn;
	private final String author;

}
