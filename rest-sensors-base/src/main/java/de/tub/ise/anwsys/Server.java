package de.tub.ise.anwsys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import de.tub.ise.anwsys.models.*;
import de.tub.ise.anwsys.repos.*;

@SpringBootApplication
@ComponentScan("de.tub.ise.anwsys")
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
    
    /*********************************FOR TESTING:START*******************************/
<<<<<<< HEAD
    @Bean
    CommandLineRunner init(SmartMeterRepository smRepo, MetricRepository mRepo, MearsurementRepository measR) {
    	
    	Metric mc = mRepo.save(new Metric("Current(mA)"));
        Metric mv = mRepo.save(new Metric("Voltage(V)"));
    	
        List<Metric> metrics = new ArrayList<>();
        metrics.add(mc);
        metrics.add(mv);
        
    	return (evt) -> Arrays.asList(
       "01,02".split(","))
       .forEach(
         a -> {
          SmartMeter sm = smRepo.save(new SmartMeter(a, metrics));
          measR.save(new Measurement(mc, sm, 123456,  247.9875));
          measR.save(new Measurement(mv, sm, 123456,  555.555555));
         });
    }
=======
    @Bean
	CommandLineRunner init(SmartMeterRepository smRepo, MetricRepository mRepo, MeasurementRepository measR) {
		return (evt) -> Arrays.asList(
				"SM_jhoeller,SM_dsyer".split(","))
				.forEach(
						a -> {
							SmartMeter sm = smRepo.save(new SmartMeter(a));
							Metric mc = mRepo.save(new Metric(sm, "Current(mA)"));
							Metric mv = mRepo.save(new Metric(sm, "Voltage(V)"));
							measR.save(new Measurement(mc, 123456,  247.9875));
							measR.save(new Measurement(mv, 123456,  555.555555));
						});
	}
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
    //,SM_pwebb,SM_ogierke,SM_rwinch,SM_mfisher,SM_mpollack,SM_jlong
    /*********************************FOR TESTING:END*********************************/
}
