/**
 * 
 */
package com.karuriSuro.newsStation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author surajitkaruri
 *
 */


// For static ng application only
@Controller
public class AppLoadController {
	
	
	@GetMapping("/")
	public String loadHomePage() {
		return "index";
	}

}
