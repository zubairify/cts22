package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Flight;
import com.cts.extra.InvalidFlightException;
import com.cts.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repo;
	
	@Override
	public int save(Flight f) {
		repo.save(f);
		return f.getCode();
	}

	@Override
	public Flight fetch(int code) throws InvalidFlightException {
		return repo.findById(code).orElseThrow(() -> new InvalidFlightException("Invalid code: " + code));
	}

	@Override
	public List<Flight> list() {
		return repo.findAll();
	}

	@Override
	public boolean remove(int code) {
		repo.deleteById(code);
		return true;
	}

	@Override
	public List<Flight> byCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> byRoute(String source, String destiny) {
		return repo.findByRoute(source, destiny);
	}
}
