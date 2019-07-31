package com.glb.training.bookstoreratingms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glb.training.bookstoreratingms.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
