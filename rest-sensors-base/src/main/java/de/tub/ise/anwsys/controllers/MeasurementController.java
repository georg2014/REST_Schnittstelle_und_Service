package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.repos.MearsurementRepository;

@RestController
@RequestMapping("/smartMeter/{smId}/data")
public class MeasurementController {
	
	@Autowired MearsurementRepository measrep;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Measurement> getSmartMeterMetricsData(@PathVariable String smId) {
		return (List<Measurement>) measrep.findBySmartMeterId(smId);
	}
	
}
