package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.MearsurementRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping("/smartMeter/{smId}/data")
public class MeasurementController {
	
	@Autowired MearsurementRepository measRepo;
	@Autowired SmartMeterRepository smartRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Measurement> getSmartMeterMetricsData(@PathVariable String smId) {
		System.out.println(smId);
		SmartMeter get = smartRepo.findFirstByMeterId(smId);
		System.out.println(get.getMeterId());
		return (List<Measurement>) measRepo.findAll();
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
