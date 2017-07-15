package de.tub.ise.anwsys.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.models.SmartMeter;

public interface MearsurementRepository extends JpaRepository<Measurement, String>{
		
		List<Measurement> findBySmart(SmartMeter smart);
		
		List<Measurement> findByMeasId(String id);
		
		@Query(value = "SELECT AVG(value) FROM (SELECT * FROM measurement WHERE smart=:selectedSmart AND met=:selectedMetric) GROUP BY(timestamp/2)", nativeQuery=true)
		List<Double> getValuesAveraged(@Param("selectedSmart") SmartMeter selectedSmart, @Param("selectedMetric") Metric selectedMetric);
		
		@Query(value = "SELECT AVG(value) FROM (SELECT * FROM measurement WHERE smart=:selectedSmart AND met=:selectedMetric) WHERE timestamp BETWEEN :selectedTime AND :selectedTime+2 ", nativeQuery=true)
		Double getAverageValue(@Param("selectedTime") long selectedTime,@Param("selectedSmart") SmartMeter selectedSmart, @Param("selectedMetric") Metric selectedMetric);

}

