package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.maven.testpkg.*;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public void testMsg() {
		System.out.println(TestMsg.testMessage());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
