package de.tub.ise.anwsys;

import java.util.Arrays;

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
	CommandLineRunner init(SmartMeterRepository smR, MetricRepository mR, MearsurementRepository measR) {
		return (evt) -> Arrays.asList(
				"SM_jhoeller,SM_dsyer".split(","))
				.forEach(
						a -> {
							SmartMeter sm = smR.save(new SmartMeter(a));
							Metric mc = mR.save(new Metric(sm, "Current(mA)"));
							Metric mv = mR.save(new Metric(sm, "Voltage(V)"));
							measR.save(new Measurement(mc, 123456,  247.9875));
							measR.save(new Measurement(mv, 123456,  555.555555));
						});
	}
    //,SM_pwebb,SM_ogierke,SM_rwinch,SM_mfisher,SM_mpollack,SM_jlong
    /*********************************FOR TESTING:END*********************************/
}
