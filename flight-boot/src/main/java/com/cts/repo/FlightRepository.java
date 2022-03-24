package com.cts.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findByCarrier(String carrier);
	
	@Query("FROM Flight WHERE source=:src AND destiny=:dest")
	List<Flight> findByRoute(String src, String dest);
	
//	List<Flight> findBySourceAndDestiny(String source, String destiny);
	
}
