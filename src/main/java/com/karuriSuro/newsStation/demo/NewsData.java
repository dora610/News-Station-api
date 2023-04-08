/**
 * 
 */
package com.karuriSuro.newsStation.demo;

import java.util.Date;

/**
 * @author surajitkaruri
 *
 */
public record NewsData(String headline, String subHeading, String img, Date publishedOn, boolean isMainStory, String author,
		String category) {}
