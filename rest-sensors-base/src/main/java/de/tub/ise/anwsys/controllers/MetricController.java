package de.tub.ise.anwsys.controllers;

<<<<<<< HEAD
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
=======
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
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
@RequestMapping("/smartMeter/metric")
=======
<<<<<<< HEAD
@RequestMapping("/smartMeter/{smId}")
=======
@RequestMapping("/smartMeter/{id}")
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
public class MetricController {
<<<<<<< HEAD

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
=======
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
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
	}

}
