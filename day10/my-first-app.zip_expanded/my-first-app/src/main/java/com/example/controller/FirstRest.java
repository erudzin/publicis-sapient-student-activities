package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/first")

public class FirstRest {

	@GetMapping
	public String greetings() {
		return "Welcome to REST";
	}
	
	@GetMapping("/hello")
	public Map<String, String> getJson() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Alexandar");
		map.put("email", "alexandar1234@abc.com");
		return map;
	}
	
	@PostMapping("/hello")
	public Map<String, String> postJson() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Hello Post");
		return map;
	}
	
	@PutMapping("/hello")
	public Map<String, String> putJson() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Hello Put");
		return map;
	}
	
	@DeleteMapping("/hello")
	public Map<String, String> deleteJson() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Hello Delete");
		return map;
	}
}
