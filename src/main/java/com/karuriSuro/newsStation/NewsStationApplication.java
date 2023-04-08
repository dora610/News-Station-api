package com.karuriSuro.newsStation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karuriSuro.newsStation.dao.NewsRepository;
import com.karuriSuro.newsStation.entity.News;
import com.karuriSuro.newsStation.model.NewsPreview;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NewsStationApplication {
	
	private static Logger logger = LoggerFactory.getLogger(NewsStationApplication.class);
	
	@Autowired
	NewsRepository newsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NewsStationApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner runner() {
		return (args)->{
			
//			newsRepository.save(new News("test heading1", "subheading1", "/img1", LocalDateTime.now(), "/url-test1", false, "Sara Morrison", "Social"));
//			newsRepository.save(new News("test heading2", "subheading2", "/img2", LocalDateTime.now(), "/url-test2", false, "Alex Abad-Santos", "Sports"));
			
			newsRepository.findAll().stream()
				.forEach(n -> {
					logger.info(n.toString());
				});
			
			File file = ResourceUtils.getFile("data/newspreview.json");
			logger.info(file.getAbsolutePath());
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<NewsPreview> typeReference = new TypeReference<NewsPreview>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/newspreview.json");
			try {
				NewsPreview newsPreviewTest = mapper.readValue(inputStream, typeReference);
				logger.info(newsPreviewTest.toString());
				logger.info("data loaded from json file");
			} catch (IOException e) {
				logger.error("Unable to read file");
				e.printStackTrace();
			}
			
		};
	}

}
