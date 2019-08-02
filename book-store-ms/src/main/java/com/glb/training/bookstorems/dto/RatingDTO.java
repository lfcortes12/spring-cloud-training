package com.glb.training.bookstorems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingDTO {
	
	private Long bookId;
	private Long value;

}
