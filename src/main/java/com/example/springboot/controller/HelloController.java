package com.example.springboot.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String index() {
		return "Hello World!";
	}
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity("Good Afternoon!", HttpStatusCode.valueOf(200));
	}
}

@RestController
class HelloController2 {
	@GetMapping("/info")
	public ResponseEntity<String> getInfo() {
		return new ResponseEntity(HttpStatusCode.valueOf(200));
	}
}
@RestController
class HelloController3 {
	@GetMapping("/random")
	public ResponseEntity<String> random() {
		boolean random = new Random().nextBoolean();
		if(random) {
			return ResponseEntity.ok("It's true");
		}
		return ResponseEntity.badRequest().body("It's false!");
	}
}