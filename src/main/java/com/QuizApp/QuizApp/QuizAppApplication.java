package com.QuizApp.QuizApp;

import io.unlogged.Unlogged;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication {


	@Unlogged
	public static void main(String[] args) {
		 SpringApplication.run(QuizAppApplication.class, args);
	}

}
