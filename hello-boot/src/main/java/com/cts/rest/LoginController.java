package com.cts.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pojo.Login;

@RestController
public class LoginController {

	// http://localhost:8880/login?user=duke&pass=java
	@GetMapping(value = "/login", produces = "text/html")
	public String validate(@RequestParam String user, @RequestParam String pass) {
		if(user.equals("duke") && pass.equals("java"))
			return "<h1>Login Successful</h1>";
		else
			return "<h1>Login Failed</h1>";
	}
	
	@PostMapping(value = "/loginjson", consumes = "application/json", produces = "text/html")
	public String validateJson(@RequestBody Login login) {
		if(login.getUser().equals("duke") && login.getPass().equals("java"))
			return "<h1>Login Successful</h1>";
		else
			return "<h1>Login Failed</h1>";
	}
}
