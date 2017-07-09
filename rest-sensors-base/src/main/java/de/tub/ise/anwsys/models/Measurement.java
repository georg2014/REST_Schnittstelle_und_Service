package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Measurement implements Serializable {

	private static final long serialVersionUID = -9138848863259362629L;
	
	//Attributes
	@Id
	@GeneratedValue
	@Column
	String id;
	
	@ManyToOne
	@JoinColumn
	Metric met;
	
	@Column
	long timestamp;
	
	@Column
	double value;
	
	//constructors
	public Measurement(){
		
	}
	
	public Measurement(Metric met, long timestamp, double value){
		this.met = met;
		this.timestamp = timestamp;
		this.value = value;
	}
	
	//getter setters
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public Metric getMet() {
		return met;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
