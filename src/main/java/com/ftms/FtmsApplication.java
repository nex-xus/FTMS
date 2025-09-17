package com.ftms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ftms")
public class FtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtmsApplication.class, args);
	}

}
