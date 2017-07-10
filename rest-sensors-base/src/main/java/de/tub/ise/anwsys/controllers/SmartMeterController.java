package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
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
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;
=======
import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10

@RestController
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository smRepo;
	
	@RequestMapping(method=RequestMethod.GET)
<<<<<<< HEAD
	public List<SmartMeter> getAllSmartMeters(){
=======
<<<<<<< HEAD
=======
	public String start() {
		return String.format("Willkommen auf der SmartMeter Seite!  "
				+ "<br>  /all -> alle SmartMeter"
				+ "<br>  /{id} -> SmartMeter mit der {id}");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	public List<SmartMeter> getAllSmartMeter(){
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
		return (List<SmartMeter>) smRepo.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{meterId}")
	public List<Metric> getMetrics(@PathVariable String meterId){
		SmartMeter m = smRepo.findOne(meterId);
		System.out.println(m.getMeterId());
		return m.getMetric();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		return smRepo.save(new SmartMeter(smartMeter.getMeterId(), smartMeter.getMetric()));
	}
	
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public SmartMeter updateSmartMeter(@RequestBody SmartMeter s, @PathVariable String id){
		SmartMeter smartMeter = smRepo.findOne(id);
		smartMeter.setMetric(s.getMetric());
		smartMeter.setMeas(s.getMeas());
		return (SmartMeter) smRepo.save(smartMeter);
	}
	
=======
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
	@RequestMapping(method=RequestMethod.DELETE, value="/{meterId}")
	public ResponseEntity<Void> delete(@PathVariable String meterId){
		smRepo.delete(meterId);
		return ResponseEntity.ok().build();
	}

}
