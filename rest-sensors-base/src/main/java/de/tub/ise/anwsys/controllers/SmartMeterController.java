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
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository repository;
		
//	@RequestMapping(method=RequestMethod.GET)
//	public String answerAndRegister(@RequestParam(value = "smartmeter", defaultValue = "AnwSys SmartMeter") String kennung) {
//		List<SmartMeter> foundSmartMeter = repository.findByKennung(kennung);
//		if (!foundSmartMeter.isEmpty()) {
//			return String.format("New SmartMeter, %s.", foundSmartMeter.get(0).getKennung());
//		} else {
//			SmartMeter s = new SmartMeter(kennung);
//			repository.save(s);
//			return String.format("New SmartMeter %s!", s.getKennung());
//		}
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String start() {
		return String.format("Willkommen auf der SmartMeter Seite!    /all -> alle");
	}
	
	//shows all smartMeters
	@RequestMapping(method=RequestMethod.GET, path="/all")
	public List<SmartMeter> getAllSmartMeter(){
		return (List<SmartMeter>) repository.findAll(); 
	}
	//shows a single smartMeter
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public SmartMeter getSingleSmartmeter(@PathVariable(name="id", required=true)Long id){
		return repository.findById(id);
	}
	
	//creates a new smartMeter
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter sm){
		SmartMeter s = new SmartMeter(sm.getKennung(), sm.getSpannung(), sm.getStromstärke());
		return repository.save(s);
	}	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteSmartMeter(@PathVariable(name="id", required=true)Long id){
		SmartMeter s = repository.findById(id);
		repository.delete(s);
	}

}
