//package com.tnsif.College;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class CollegeServiceApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CollegeServiceApplication.class, args);
//	}
//
//}





package com.tnsif.College;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegeServiceApplication {

	public static void main(String[] args) {
		System.out.println("🚀 Starting College Service Application...");
		SpringApplication.run(CollegeServiceApplication.class, args);
		System.out.println("✅ College Service Application is running successfully!");
	}
}
