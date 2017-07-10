package de.tub.ise.anwsys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.SmartMeter;

public interface SmartMeterRepository extends JpaRepository<SmartMeter, String>{
	
	SmartMeter findFirstByMeterId(String meterId);

}
