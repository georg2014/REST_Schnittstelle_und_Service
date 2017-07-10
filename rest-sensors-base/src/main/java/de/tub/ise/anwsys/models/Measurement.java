package de.tub.ise.anwsys.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
=======
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10

@Entity
public class Measurement implements Serializable {

	private static final long serialVersionUID = -9138848863259362629L;
	
	//Attributes
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.AUTO)
	long measId;
=======
	@GeneratedValue
<<<<<<< HEAD
	String measId;
=======
	@Column
	String measurementId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
	
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
	}
	
	//getter setters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

<<<<<<< HEAD
	public long getMeasId() {
=======
<<<<<<< HEAD
	public String getmeasId() {
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
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
	
	public SmartMeter getSmart(){
		return smart;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setMet(Metric met) {
		this.met = met;
	}

	public void setSmart(SmartMeter smart) {
		this.smart = smart;
	}

}
