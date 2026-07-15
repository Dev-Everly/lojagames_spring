package com.generation.hello_world.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica classe controladora 
@RequestMapping("/hello") //indica classe de requisição (endpoint)

public class HelloController {
	
	@GetMapping
	public String helloWorld() {
		return "Hello World!";
	}
	@GetMapping("/turma")
	public String turmaJava85() {
		return "<b>A turma Java 85 é TOP!<b>";
	}
}
