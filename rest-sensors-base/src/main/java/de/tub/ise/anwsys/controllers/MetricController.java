package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.MetricRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
public class MetricController {
	
	@Autowired MetricRepository metrep;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Metric> getAllMetric(){
		return (List<Metric>) metrep.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Metric getSingleSmartmeter(@PathVariable String id){
		return metrep.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Metric createSmartMeter(@RequestBody Metric metric){
		return metrep.save(metric);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteSmartMeter(@PathVariable String id){
		metrep.delete(id);
	}

}
