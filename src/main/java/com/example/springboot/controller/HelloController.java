package com.example.springboot.controller;

import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static javax.security.auth.callback.ConfirmationCallback.OK;

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
	public ResponseEntity getInfo() {
		return new ResponseEntity(HttpStatusCode.valueOf(200));
	}
}
@RestController
class HelloController3 {
	@GetMapping("/random")
	public ResponseEntity random() {
		boolean random = new Random().nextBoolean();
		if(random) {
			return new ResponseEntity("It's true", HttpStatusCode.valueOf(200));
		}
		return new ResponseEntity("It's false", HttpStatusCode.valueOf(400));
	}
}