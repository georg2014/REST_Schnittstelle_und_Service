package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Measurement implements Serializable {

	private static final long serialVersionUID = -9138848863259362629L;
	
	//Attributes
	@Id
	@GeneratedValue
	String measId;
	
	long timestamp;
	
	double value;
	
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

	public String getmeasId() {
		return measId;
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
