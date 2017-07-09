package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository smRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SmartMeter> getAllSmartMeter(){
		return (List<SmartMeter>) smRepo.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		return smRepo.save(new SmartMeter(smartMeter.getSmId()));
	}
	
	//should it be possible to change the id?
	/*
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public SmartMeter updateSmartMeter(@RequestBody SmartMeter s, @PathVariable String id){
		List<SmartMeter> smartMeter = smRepo.findById(id);
		((SmartMeter) smartMeter).setId(s.getId());
		return (SmartMeter) smRepo.save(smartMeter);
	}
	*/
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{meterId}")
	public void deleteSmartMeter(@PathVariable String meterId){
		smRepo.delete(meterId);
	}

}
