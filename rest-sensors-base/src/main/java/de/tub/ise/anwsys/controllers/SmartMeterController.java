package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository repository;
		
	@RequestMapping(method=RequestMethod.GET, path="/hello2")
	public String answerAndRegister(@RequestParam(value = "smartmeter", defaultValue = "AnwSys SmartMeter") String id) {
		List<SmartMeter> foundSmartMeter = repository.findById(id);
		if (!foundSmartMeter.isEmpty()) {
			return String.format("New SmartMeter, %s.", foundSmartMeter.get(0).getId());
		} else {
			SmartMeter s = new SmartMeter(id);
			repository.save(s);
			return String.format("New SmartMeter %s!", s.getId());
		}
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<SmartMeter> getAllSmartMeter(){
		return (List<SmartMeter>) repository.findAll(); 
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public List<SmartMeter> getSmartmeter(@PathVariable String id){
		return repository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		SmartMeter s = new SmartMeter(smartMeter.getId());
		return repository.save(s);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public SmartMeter updateSmartMeter(@RequestBody SmartMeter s, @PathVariable String id){
		List<SmartMeter> smartMeter = repository.findById(id);
		((SmartMeter) smartMeter).setId(s.getId());
		return (SmartMeter) repository.save(smartMeter);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{name}")
	public void deleteUser(@PathVariable String name){
		repository.delete(name);
	}

}
