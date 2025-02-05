package com.kht.PizzaMenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaMenuApplication.class, args);
	}
	/*
		프로젝트 시작 (main)
			main 1개
		↓
		config - 설정확인
		↓
		controller
		↓
		/api/..
		↓
		service
		↓
		mapper
	 */
}
