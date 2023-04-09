package com.karuriSuro.newsStation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karuriSuro.newsStation.dao.NewsRepository;

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
		return (args) -> {

			/*
			 * ObjectMapper mapper = new ObjectMapper(); TypeReference<List<NewsData>>
			 * typeReference = new TypeReference<List<NewsData>>() {}; InputStream
			 * inputStream =
			 * TypeReference.class.getResourceAsStream("/data/newspreview.json");
			 * 
			 * try { List<NewsData> dataList = mapper.readValue(inputStream, typeReference);
			 * logger.info("data loaded from json file");
			 * 
			 * dataList.stream().map(d -> { News newsDemo = new News(d.headline(),
			 * d.subHeading(), d.img(),
			 * d.publishedOn().toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime
			 * (), d.isMainStory(), d.author(), d.category());
			 * newsRepository.save(newsDemo); return d.toString();
			 * }).forEach(NewsStationApplication.logger::info);
			 * 
			 * } catch (IOException e) { logger.error("Unable to read file");
			 * e.printStackTrace(); }
			 */

			logger.info("Data fetched from db");
			newsRepository.findAll().stream().map(Object::toString).forEach(NewsStationApplication.logger::info);

		};

	}

}
