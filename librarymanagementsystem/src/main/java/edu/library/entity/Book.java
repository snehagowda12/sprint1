package edu.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="library")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "serialName", length = 50, nullable = false)
	private String serialName;

	@Column(name = "description", length = 250, nullable = false)
	private String description;

	@Column(name = "publisher", length = 250, nullable = false)
	private String publisher;
	
	@Column(name = "category", length = 250, nullable = false)
	private String category;
	
	@Column(name = "author", length = 250, nullable = false)
	private String author;
}
