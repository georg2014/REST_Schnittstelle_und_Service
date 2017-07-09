package de.tub.ise.anwsys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Measurement;

public interface MearsurementRepository extends JpaRepository<Measurement, String>{
	List<Measurement> findById(String id);

}

