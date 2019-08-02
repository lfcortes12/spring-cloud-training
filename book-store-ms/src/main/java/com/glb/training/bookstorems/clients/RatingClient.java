package com.glb.training.bookstorems.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glb.training.bookstorems.dto.RatingDTO;

@FeignClient("book-store-rating-ms")
public interface RatingClient {
	
	@RequestMapping("/rating/book/{bookId}")
	RatingDTO findBookRating(@PathVariable("bookId") Long bookId);

}
