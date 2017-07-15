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
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository smRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SmartMeter> getAllSmartMeters(){
		return (List<SmartMeter>) smRepo.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{meterId}")
	public List<Metric> getMetrics(@PathVariable String meterId){
		SmartMeter m = smRepo.findOne(meterId);
		return m.getMetric();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		return smRepo.save(new SmartMeter(smartMeter.getMeterId(), smartMeter.getMetric()));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{meterid}")
	public SmartMeter updateSmartMeter(@RequestBody SmartMeter s, @PathVariable String id){
		SmartMeter smartMeter = smRepo.findOne(id);
		smartMeter.setMetric(s.getMetric());
		smartMeter.setMeas(s.getMeas());
		return (SmartMeter) smRepo.save(smartMeter);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{meterId}")
	public ResponseEntity<Void> delete(@PathVariable String meterId){
		smRepo.delete(meterId);
		return ResponseEntity.ok().build();
	}

}
