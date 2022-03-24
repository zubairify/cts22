package com.cts.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class ContentController {

	// http://localhost:8880/text/Zubair
	@GetMapping(value = "/text/{name}", produces = "text/plain")
	public String greetText(@PathVariable String name) {
		return "Text: Welcome to Spring Boot, " + name;
	}
	
	// http://localhost:8880/html?name=Zubair
	@GetMapping(value = "/html", produces = "text/html")
	public String greetHtml(@RequestParam String name) {
		return "<h1>HTML: Welcome to Spring Boot, " + name + "</h1>";
	}
	
	// http://localhost:8880/xml
	@GetMapping(value = "/xml", produces = "text/xml")
	public String greetXml() {
		return "<?xml version=\"1.0\"?><greeting>XML:Welcome to Spring Boot</greeting>";
	}
	
	// http://localhost:8880/json
	@GetMapping(value = "/json", produces = "application/json")
	public String greetJson() {
		JSONPObject obj = new JSONPObject("greeting", "JSON: Welcome to Spring Boot");
		return obj.getValue().toString();
	}
}
