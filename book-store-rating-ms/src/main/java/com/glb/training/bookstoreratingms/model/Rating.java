package com.glb.training.bookstoreratingms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "book")
@Builder
@Getter
@AllArgsConstructor
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long bookId;
	@Column
	private final Long value;

}
