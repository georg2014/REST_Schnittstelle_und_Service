package de.tub.ise.anwsys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Metric;

public interface MetricRepository extends JpaRepository<Metric, String>{
	
	List<Metric> findById(String id);

}