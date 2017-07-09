package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@RestController
@RequestMapping("/metric")
public class MetricController {
	
	@Autowired MetricRepository metrep;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Metric> getAllMetric(){
		return (List<Metric>) metrep.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Metric getSingleMetric(@PathVariable String id){
		return metrep.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric){
		return metrep.save(metric);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteMetric(@PathVariable String id){
		metrep.delete(id);
	}

}
