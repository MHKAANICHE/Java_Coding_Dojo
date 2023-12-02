package com.codingdojo.hoppersreceipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HoppersReceipt1Application {

	public static void main(String[] args) {
		 ApplicationContext context = SpringApplication.run(HoppersReceipt1Application.class, args);
		 
//		 @Autowired
//		 CardController cardController;
		 
		 //context.getBean(new CardController());
	}

}
