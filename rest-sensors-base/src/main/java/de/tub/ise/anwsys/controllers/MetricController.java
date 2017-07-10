package de.tub.ise.anwsys.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

<<<<<<< HEAD
import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.repos.MetricRepository;
=======
import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

@RestController
<<<<<<< HEAD
@RequestMapping("/smartMeter/{smId}")
=======
@RequestMapping("/smartMeter/{id}")
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
public class MetricController {
<<<<<<< HEAD

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
=======
	
	@Autowired MetricRepository mRepo;
	
	//TODO
//	@RequestMapping(method=RequestMethod.GET)
//	public List<Metric> getSmartMeterMetrics(@PathVariable String metricId){
//		return mRepo.findBySmId(metricId);
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Metric getSingleMetric(@PathVariable String metricId){
		return mRepo.findOne(metricId);
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	}
<<<<<<< HEAD

//	@RequestMapping(method=RequestMethod.PUT)
//	public Metric updateMetric(@RequestBody Metric metric){
//		return metrep.
//	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{metId}")
	public void deleteMetric(@PathVariable String metId) {
		metrep.delete(metId);
=======
	
	@RequestMapping(method=RequestMethod.POST)
	public Metric createMetric(@RequestBody Metric metric){
		return mRepo.save(metric);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteMetric(@PathVariable String metricId){
		mRepo.delete(metricId);
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	}

}
