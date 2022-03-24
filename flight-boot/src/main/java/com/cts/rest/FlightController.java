package com.cts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cts.entity.Flight;
import com.cts.extra.InvalidFlightException;
import com.cts.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String addFlight(@RequestBody Flight f) {
		int code = service.save(f);
		return "Flight added with code: " + code;
	}
	
	@GetMapping(value = "/get/{code}", produces = "application/json")
	public Flight getFlight(@PathVariable int code) {
		try {
			return service.fetch(code);
		} catch (InvalidFlightException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Flight> getList() {
		return service.list();
	}
	
	@DeleteMapping(value = "/del/{code}")
	public String delete(@PathVariable int code) {
		service.remove(code);
		return "Flight deleted";
	}
	
	@GetMapping(value = "/carrier/{car}", produces = "application/json")
	public List<Flight> listByCarrier(@PathVariable("car") String carrier) {
		return service.byCarrier(carrier);
	}
	
	@GetMapping(value = "/route", produces = "application/json")
	public List<Flight> listByRoute(@RequestParam String source, @RequestParam String destiny) {
		return service.byRoute(source, destiny);
	}
}
