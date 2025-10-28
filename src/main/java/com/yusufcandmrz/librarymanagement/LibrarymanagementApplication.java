package com.yusufcandmrz.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrarymanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarymanagementApplication.class, args);
    }

	/*
    Bonus Challenges
    - Add pagination & sorting to /books
    - Add filtering (e.g. /books?available=true)
    - Secure the API with JWT later
    - Add a Swagger UI (springdoc-openapi-starter-webmvc-ui)
	 */

}
