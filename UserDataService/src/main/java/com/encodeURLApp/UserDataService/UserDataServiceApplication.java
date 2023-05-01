package com.encodeURLApp.UserDataService;

import com.encodeURLApp.UserDataService.repository.UserDAL;
import com.encodeURLApp.UserDataService.repository.UserDALImpl;
import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserDataServiceApplication {
	@Bean
	public UserDAL getUserDAL(){
		return new UserDALImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserDataServiceApplication.class, args);
	}
}
