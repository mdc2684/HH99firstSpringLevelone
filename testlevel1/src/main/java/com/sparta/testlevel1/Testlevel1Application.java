package com.sparta.testlevel1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //Timestamp 관련 뭐 사용한다는거같다.
@SpringBootApplication
public class Testlevel1Application {

	public static void main(String[] args) {
		SpringApplication.run(Testlevel1Application.class, args);
	}

}
