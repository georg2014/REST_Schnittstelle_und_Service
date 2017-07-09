package de.tub.ise.anwsys.repos;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Metric;

public interface MetricRepository extends JpaRepository<Metric, String>{
	List<Metric> findByMetricId(String metricId);
	//TODO
//	List<Metric> findBySmId(String metricId);
	
}