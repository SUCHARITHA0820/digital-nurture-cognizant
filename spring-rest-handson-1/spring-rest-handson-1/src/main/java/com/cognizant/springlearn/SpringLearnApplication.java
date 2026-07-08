package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		logger.info("===== Entering main() method of SpringLearnApplication =====");

		SpringApplication.run(SpringLearnApplication.class, args);

		logger.info("===== SpringLearnApplication started successfully =====");

		displayDate();

		displayCountry();
	}

	private static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);

		logger.debug("Country : {}", country.toString());
		System.out.println("Country details: " + country);

		((ClassPathXmlApplicationContext) context).close();
	}

	private static void displayDate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = format.parse("31/12/2018");
			System.out.println("Parsed date using dateFormat bean: " + date);
			logger.info("Parsed date using dateFormat bean: {}", date);
		} catch (ParseException e) {
			logger.error("Unable to parse date", e);
		} finally {
			((ClassPathXmlApplicationContext) context).close();
		}
	}

}
