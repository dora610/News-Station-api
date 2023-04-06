/**
 * 
 */
package com.karuriSuro.newsStation.modal;

import java.time.LocalDateTime;

/**
 * @author surajitkaruri
 *
 */
public record NewsPreview(
		String headline, 
		String subHeading, 
		String desc, 
		String img, 
		LocalDateTime publishedOn,
		String url, 
		boolean isMainStory, 
		String author
		) {}
