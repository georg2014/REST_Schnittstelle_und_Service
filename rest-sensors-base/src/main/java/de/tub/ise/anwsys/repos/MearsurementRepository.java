package de.tub.ise.anwsys.repos;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.models.SmartMeter;

public interface MearsurementRepository extends JpaRepository<Measurement, String>{
		
		//retrieves all measurements depending on the corresponding meter and metric
		List<Measurement> findBySmartAndMet(SmartMeter smart, Metric met);
		
		//retrieves the measurement with the corresponding id
		List<Measurement> findByMeasId(String id);
		
		//retrieves the average value of the 900 measurements from the measurement with the given timestamp and the 900 following
		@Query(value = "SELECT AVG(value) FROM (SELECT * FROM measurement WHERE smart=:selectedSmart AND met=:selectedMetric) WHERE timestamp BETWEEN :selectedTime AND :selectedTime+899", nativeQuery=true)
		Double getAverageValue(@Param("selectedTime") long selectedTime,@Param("selectedSmart") SmartMeter selectedSmart, @Param("selectedMetric") Metric selectedMetric);

		
}

