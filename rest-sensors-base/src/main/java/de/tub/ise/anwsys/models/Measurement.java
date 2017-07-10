package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
=======
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git

@Entity
public class Measurement implements Serializable {

	private static final long serialVersionUID = -9138848863259362629L;
	
	//Attributes
	@Id
	@GeneratedValue
<<<<<<< HEAD
	String measId;
=======
	@Column
	String measurementId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	
<<<<<<< HEAD
	long timestamp;
	
	double value;
	
=======
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	Metric met;
	
	@ManyToOne
	@JoinColumn
	SmartMeter smart;
	
	//constructors
	public Measurement(){
		
	}
	
	public Measurement(Metric met, SmartMeter smart, long timestamp, double value){
		this.met = met;
		this.smart = smart;
		this.timestamp = timestamp;
		this.value = value;
		System.out.println(value);
	}
	
	//getter setters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

<<<<<<< HEAD
	public String getmeasId() {
		return measId;
=======
	public double getValue() {
		return value;
	}

	public String getId() {
		return measurementId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	}

	public Metric getMet() {
		return met;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	public double getValue(){
		return value;
	}

}
