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
    //,SM_pwebb,SM_ogierke,SM_rwinch,SM_mfisher,SM_mpollack,SM_jlong
    /*********************************FOR TESTING:END*********************************/
}
