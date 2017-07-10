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

	@RequestMapping(method = RequestMethod.GET)
	public List<Metric> getAllMetrics() {
		return (List<Metric>) metRepo.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric) {
		if (!metRepo.exists(Long.toString(metric.getMetId()))) {
			return metRepo.save(new Metric(metric.getMeasvar()));
		} else {
			return null;
		}
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/{metId}")
	public Metric update(@PathVariable String metId, @RequestBody Metric metric){
		Metric m = metRepo.findOne(metId);
		m.setData(metric.getData());
		m.setMeasvar(metric.getMeasvar());
		return metRepo.save(m);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = "/{metId}")
	public ResponseEntity<Void> delete(@PathVariable String metId) {
		metRepo.delete(metId);
		return ResponseEntity.ok().build();
	}

}
