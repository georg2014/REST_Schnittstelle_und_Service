package de.tub.ise.anwsys.repos;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, String>{
	List<Measurement> findByMeasurementId(String measurementId);

}

