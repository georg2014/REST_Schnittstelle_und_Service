package de.tub.ise.anwsys.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Measurement implements Serializable {

	private static final long serialVersionUID = -9138848863259362629L;
	
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long measId;
	
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
	}
	
	//getter setters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getMeasId() {
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
