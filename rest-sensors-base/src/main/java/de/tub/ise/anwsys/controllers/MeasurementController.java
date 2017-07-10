package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

<<<<<<< HEAD
import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.repos.MearsurementRepository;
=======
import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

@RestController
@RequestMapping("/smartMeter/{smId}/data")
public class MeasurementController {
	
	@Autowired MeasurementRepository measRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Measurement> getAllMetric(){
		return (List<Measurement>) measRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Measurement> getSmartMeterMetricsData(@PathVariable String smId) {
		return (List<Measurement>) measrep.findBySmartMeterId(smId);
	}
	
}
