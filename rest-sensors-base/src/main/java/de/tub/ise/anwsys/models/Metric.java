package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Metric implements Serializable {
	
	private static final long serialVersionUID = 3025270242924152998L;
	
	//attributes
	@Id
	String metricId;
	
	//The measured variable
	@Column
	String metricText;
	
	//Reference to the corresponding Smart Meters
	@JsonIgnore
	@ManyToMany(mappedBy="metric")
	List<SmartMeter> sm;
	
	//Reference to the corresponding measurements for this variable
	@JsonIgnore
	@OneToMany(mappedBy="met")
	List<Measurement> data;
	
	//constructors
	public Metric(String metricId,String metricText){
		
		this.metricId= metricId;
		this.metricText = metricText;
		
	}
	public Metric(){
		
	}
	
	//getters setters
	public String getmetricText() {
		return metricText;
	}

	public void setmetricText(String metricText) {
		this.metricText = metricText;
	}

	public List<Measurement> getData() {
		return data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getmetricId() {
		return metricId;
	}

	public List<SmartMeter> getSm() {
		return sm;
	}
	public void setmetricId(String metricId) {
		
		this.metricId = metricId;
		
	}
	

}
