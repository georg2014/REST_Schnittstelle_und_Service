package de.tub.ise.anwsys.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.Measurement;

public interface MearsurementRepository extends JpaRepository<Measurement, String>{
<<<<<<< HEAD
		
		List<Measurement> findBySmartMeterId(String id);
		
		List<Measurement> findByMeasId(String id);
=======
	List<Measurement> findById(String id);
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

}

