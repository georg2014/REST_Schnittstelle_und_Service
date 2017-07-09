package de.tub.ise.anwsys;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

@SpringBootApplication
@ComponentScan("de.tub.ise.anwsys")
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
    
    /*********************************FOR TESTING:START*******************************/
    @Bean
	CommandLineRunner init(SmartMeterRepository accountRepository) {
		return (evt) -> Arrays.asList(
				"SM_jhoeller,SM_dsyer,SM_pwebb,SM_ogierke,SM_rwinch,SM_mfisher,SM_mpollack,SM_jlong".split(","))
				.forEach(
						a -> {
							SmartMeter sm = accountRepository.save(new SmartMeter(a));
						});
	}
    /*********************************FOR TESTING:END*********************************/
}
