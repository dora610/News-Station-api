/**
 * 
 */
package com.karuriSuro.newsStation.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author surajitkaruri
 *
 */

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String headline;
	private String subHeading;
	private String img;
	private LocalDateTime publishedOn;
	private String url;
	private Boolean isMainStory;
	// TODO: reference author entity
	private String author;
	// TODO: enum
	private String category;
	private String storyText;
	
	
	
	public News(String headline, String subHeading, String img, LocalDateTime publishedOn, String url,
			Boolean isMainStory, String author, String category) {
		this.headline = headline;
		this.subHeading = subHeading;
		this.img = img;
		this.publishedOn = publishedOn;
		this.url = url;
		this.isMainStory = isMainStory;
		this.author = author;
		this.category = category;
	}
	
}
