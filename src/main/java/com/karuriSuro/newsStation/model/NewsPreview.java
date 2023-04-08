/**
 * 
 */
package com.karuriSuro.newsStation.model;

import java.time.LocalDateTime;

/**
 * @author surajitkaruri
 *
 */
public record NewsPreview(
		String headline, 
		String subHeading, 
		String img, 
		LocalDateTime publishedOn,
		String url, 
		boolean isMainStory, 
		String author
	) {}
