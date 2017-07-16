package de.tub.ise.anwsys.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.repos.MetricRepository;

@RestController
@RequestMapping("/smartMeter/metric")
public class MetricController {

	@Autowired
	MetricRepository metRepo;
	
	/**
	 * returns all metrics of smartMeters
	 * @return List<Metric>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Metric> getAllMetrics() {
		return (List<Metric>) metRepo.findAll();
	}
	
	/**
	 * creates a new metric in smartMeters
	 * @param metric
	 * @return Metric
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric) {
			return metRepo.save(new Metric(metric.getmetricId(),metric.getmetricText()));
	}
	
	/**
	 * updates a metric by metricId
	 * @param metId
	 * @param metric
	 * @return Metric
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/{metId}")
	public Metric update(@PathVariable String metId, @RequestBody Metric metric){
		Metric m = metRepo.findOne(metId);
		m.setmetricId(metric.getmetricId());
		m.setmetricText(metric.getmetricText());
		return metRepo.save(m);
	}
	
	/**
	 * deletes a metric by metricId
	 * @param metId
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{metId}")
	public ResponseEntity<Void> delete(@PathVariable String metId) {
		metRepo.delete(metId);
		return ResponseEntity.ok().build();
	}

}
