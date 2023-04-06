/**
 * 
 */
package com.karuriSuro.newsStation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karuriSuro.newsStation.modal.NewsPreview;

import lombok.extern.slf4j.Slf4j;

/**
 * @author surajitkaruri
 *
 */

@Slf4j
@RestController
@RequestMapping("/api/homepage")
public class HomePageController {
	
	Logger logger = LoggerFactory.getLogger(HomePageController.class);
	
	@GetMapping("/hlstories")
	public NewsPreview getHeadLineNews(@RequestParam(name = "count", defaultValue = "9") Integer count) {
		NewsPreview newsPreview = new NewsPreview("The ridiculous but important Twitter check mark fiasco keeps getting worse", "Twitter is finally taking away those free blue \"legacy\" checks to give its paid Twitter Blue service a boost.", null, null, null, null, false, "Sara Morrison");
		log.info("count value: " + count.toString());
		return newsPreview;
	}
}
