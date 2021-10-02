package com.fluig.fluigbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluigBackendApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FluigBackendApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
