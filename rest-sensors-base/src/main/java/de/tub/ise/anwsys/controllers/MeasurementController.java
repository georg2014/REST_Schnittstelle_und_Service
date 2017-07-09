package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
	
	@Autowired MeasurementRepository measrep;
	
}
