package de.tub.ise.anwsys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.models.SmartMeter;

public interface MearsurementRepository extends JpaRepository<Measurement, String>{
		
		List<Measurement> findBySmart(SmartMeter smart);
		
		List<Measurement> findByMeasId(String id);

}

