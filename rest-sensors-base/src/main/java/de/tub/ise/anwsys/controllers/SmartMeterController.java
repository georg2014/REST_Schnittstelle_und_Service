package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@RestController
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository smRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String start() {
		return String.format("Willkommen auf der SmartMeter Seite!    /all -> alle SmartMeter");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<SmartMeter> getAllSmartMeter(){
		return (List<SmartMeter>) smRepo.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public SmartMeter getSingleSmartmeter(@PathVariable String id){
		return smRepo.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		SmartMeter s = new SmartMeter(smartMeter.getId());
		return smRepo.save(s);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteSmartMeter(@PathVariable String id){
		smRepo.delete(id);
	}

}
