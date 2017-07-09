package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.repos.MetricRepository;

@RestController
@RequestMapping("/smartMeter/{smId}")
public class MetricController {

	@Autowired
	MetricRepository metrep;

	@RequestMapping(method = RequestMethod.GET)
	public List<Metric> getSmartMeterMetrics(@PathVariable String smId) {
		return (List<Metric>) metrep.findBySmMeterId(smId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric) {
		if (!metrep.exists(metric.getMetId())) {
			return metrep.save(new Metric(metric.getSm(), metric.getMeasvar()));
		} else {
			return null;
		}
	}

//	@RequestMapping(method=RequestMethod.PUT)
//	public Metric updateMetric(@RequestBody Metric metric){
//		return metrep.
//	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{metId}")
	public void deleteMetric(@PathVariable String metId) {
		metrep.delete(metId);
	}

}
