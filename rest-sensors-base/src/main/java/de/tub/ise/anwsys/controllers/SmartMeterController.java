package de.tub.ise.anwsys.controllers;

import java.util.List;

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

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@RestController
@RequestMapping("/smartMeter")
public class SmartMeterController {
	
	@Autowired
	SmartMeterRepository smRepo;
	
	@RequestMapping(method=RequestMethod.GET)
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
		return (List<SmartMeter>) smRepo.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public SmartMeter createSmartMeter(@RequestBody SmartMeter smartMeter){
		return smRepo.save(new SmartMeter(smartMeter.getSmId()));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{meterId}")
	public void deleteSmartMeter(@PathVariable String meterId){
		smRepo.delete(meterId);
	}

}
