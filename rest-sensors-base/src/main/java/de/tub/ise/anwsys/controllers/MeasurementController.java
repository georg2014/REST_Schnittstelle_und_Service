package de.tub.ise.anwsys.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.ise.anwsys.models.Measurement;
import de.tub.ise.anwsys.models.Metric;
import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.MearsurementRepository;
import de.tub.ise.anwsys.repos.MetricRepository;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@RestController
@RequestMapping("/smartMeter/{smId}/measurement")
public class MeasurementController {

	@Autowired
	MearsurementRepository measRepo;
	@Autowired
	SmartMeterRepository smartRepo;
	@Autowired
	MetricRepository metRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/{metId}/data")
	public ArrayList<Object[]> getSmartMeterMetricsData(@PathVariable String smId, @PathVariable String metId) {

		Metric m = metRepo.findFirstByMetricId(metId);
		SmartMeter sm = smartRepo.findFirstByMeterId(smId);
		List<Measurement> results = measRepo.findBySmartAndMet(sm, m);

		int size = results.size();

		int groups = size / 900;

		ArrayList<Object[]> averagedResults = new ArrayList<Object[]>();

		for (int i = 0; i < groups; ++i) {

			Double sum = 0.0;

			long firstTimestamp = 0;

			for (int x = 900 * i; x < (i + 1) * 900; ++x) {

				sum = sum + results.get(i).getValue();

				if (x == 900 * i) {
					firstTimestamp = results.get(x).getTimestamp();
				};

			}

			Double average = sum / 900;

			Date firstTime = new Date(firstTimestamp * 1000);

			averagedResults.add(new Object[] { firstTime.toString(), average });
		}

		return averagedResults;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/{metId}/data/all")
	public List<Measurement> getSmartMeterData(@PathVariable String smId, @PathVariable String metId) {
		
		SmartMeter smart = smartRepo.findFirstByMeterId(smId);
		Metric met = metRepo.findFirstByMetricId(metId);
		return (List<Measurement>) measRepo.findBySmartAndMet(smart, met);
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{metId}")
	public Object getSmartMeterAverageMetricData(@PathVariable String smId, @PathVariable String metId,
			@RequestParam(value = "time", required = true) String time) {

		SimpleDateFormat timeofday = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");

		try {

			Date timesection = timeofday.parse(time);
			long timestamp = timesection.getTime() / 1000L;

			SmartMeter sm = smartRepo.findFirstByMeterId(smId);
			Metric m = metRepo.findFirstByMetricId(metId);
			return measRepo.getAverageValue(timestamp, sm, m);

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Not the right Time format!");
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Measurement createMeasurement(@RequestBody Measurement meas) {
		Measurement m = new Measurement(meas.getMet(), meas.getSmart(), meas.getTimestamp(), meas.getValue());
		return measRepo.save(m);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{measId}")
	public Measurement update(@PathVariable String measId, @RequestBody Measurement meas) {
		
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
