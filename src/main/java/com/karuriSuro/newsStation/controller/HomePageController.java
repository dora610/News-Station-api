/**
 * 
 */
package com.karuriSuro.newsStation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karuriSuro.newsStation.dao.NewsRepository;
import com.karuriSuro.newsStation.entity.News;
import com.karuriSuro.newsStation.model.NewsPreview;

import lombok.extern.slf4j.Slf4j;

/**
 * @author surajitkaruri
 *
 */

@Slf4j
@RestController
@RequestMapping("/api/home")
public class HomePageController {
	
	private Logger logger = LoggerFactory.getLogger(HomePageController.class);
	
	@Autowired
	NewsRepository newsRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/hlstories")
	public List<NewsPreview> getHeadLineNews(@RequestParam(name = "count", defaultValue = "9") Integer count) {
//		NewsPreview newsPreview = new NewsPreview("The ridiculous but important Twitter check mark fiasco keeps getting worse", "Twitter is finally taking away those free blue \"legacy\" checks to give its paid Twitter Blue service a boost.", null, null, null, false, "Sara Morrison");
		log.info("count value: " + count.toString());
		
		List<NewsPreview> newsPreviews = newsRepository.findAll().stream()
				.map(HomePageController::convertToNewsPreview)
				.collect(Collectors.toList());
		return newsPreviews;
	}
	
	private static NewsPreview convertToNewsPreview(News news) {
		NewsPreview newsPreview = new NewsPreview(
				news.getHeadline(), 
				news.getSubHeading(), 
				news.getImg(), 
				news.getPublishedOn(), 
				news.getIsMainStory(), 
				news.getAuthor());
		
		return newsPreview;
	}
}
