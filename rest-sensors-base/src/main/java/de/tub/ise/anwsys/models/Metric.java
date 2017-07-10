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
	@GeneratedValue(strategy=GenerationType.AUTO)
	long metId;
	
	//The measured variable
	@Column
	String measvar;
	
	//Reference to the corresponding Smart Meters
	@JsonIgnore
	@ManyToMany(mappedBy="metric")
	List<SmartMeter> sm;
	
	//Reference to the corresponding measurements for this variable
	@JsonIgnore
	@OneToMany(mappedBy = "met")
	List<Measurement> data;
	
	//constructors
	public Metric(String measvar){
		
		this.measvar = measvar;
		
	}
	public Metric(){
		
	}
	
	//getters setters
	public String getMeasvar() {
		return measvar;
	}

	public void setMeasvar(String measvar) {
		this.measvar = measvar;
	}

	public List<Measurement> getData() {
		return data;
	}

	public void setData(List<Measurement> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getMetId() {
		return metId;
	}

	public List<SmartMeter> getSm() {
		return sm;
	}
	

}
