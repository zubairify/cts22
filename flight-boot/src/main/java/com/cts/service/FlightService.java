package com.cts.service;

import java.util.List;

import com.cts.entity.Flight;
import com.cts.extra.InvalidFlightException;

public interface FlightService {

	int save(Flight f);
	
	Flight fetch(int code) throws InvalidFlightException;
	
	List<Flight> list();
	
	boolean remove(int code);
	
	List<Flight> byCarrier(String carrier);
	
	List<Flight> byRoute(String source, String destiny);
}
