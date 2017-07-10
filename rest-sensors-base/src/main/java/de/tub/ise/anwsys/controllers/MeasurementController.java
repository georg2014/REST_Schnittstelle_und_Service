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
import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.repos.MearsurementRepository;
=======
import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

@RestController
@RequestMapping("/smartMeter/{smId}/data")
public class MeasurementController {
	
<<<<<<< HEAD
	@Autowired MearsurementRepository measRepo;
=======
	@Autowired MeasurementRepository measRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Measurement> getAllMetric(){
		return (List<Measurement>) measRepo.findAll();
	}
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Measurement> getSmartMeterMetricsData(@PathVariable String smId) {
		return (List<Measurement>) measRepo.findBySmartMeterId(smId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Measurement createMeasurement(@RequestBody Measurement meas){
		Measurement m = new Measurement(meas.getMet(), meas.getSmart(), meas.getTimestamp(),meas.getValue());
		return measRepo.save(m);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{measId}")
	public Measurement update(@PathVariable String measId, @RequestBody Measurement meas){
		Measurement m = measRepo.findOne(measId);
		m.setMet(meas.getMet());
		m.setSmart(meas.getSmart());
		m.setTimestamp(meas.getTimestamp());
		m.setValue(meas.getValue());
		return measRepo.save(m);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{measId}")
	public ResponseEntity<Void> delete(@PathVariable String measId) {
		measRepo.delete(measId);
		return ResponseEntity.ok().build();
	}
}
