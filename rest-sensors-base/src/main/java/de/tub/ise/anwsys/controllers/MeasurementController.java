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
import de.tub.ise.anwsys.repos.MearsurementRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
public class MeasurementController {
	
	@Autowired MearsurementRepository measrep;
	
}
