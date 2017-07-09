package de.tub.ise.anwsys.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@RestController
@RequestMapping("/smartMeter/{id}")
public class MetricController {
	
	@Autowired MetricRepository mRepo;
	
	//TODO
//	@RequestMapping(method=RequestMethod.GET)
//	public List<Metric> getSmartMeterMetrics(@PathVariable String metricId){
//		return mRepo.findBySmId(metricId);
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Metric getSingleMetric(@PathVariable String metricId){
		return mRepo.findOne(metricId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric){
		return mRepo.save(metric);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteMetric(@PathVariable String metricId){
		mRepo.delete(metricId);
	}

}
