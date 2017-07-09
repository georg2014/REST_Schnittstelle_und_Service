package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Metric implements Serializable {
	
	private static final long serialVersionUID = 3025270242924152998L;
	
	//attributes
	@Id
	@GeneratedValue
	@Column
	Integer id;
	
	//The measured variable
	@Column
	String measvar;
	
	//Reference to the corresponding Smart Meter
	@ManyToOne
	@JoinColumn
	SmartMeter sm;
	
	//Reference to the corresponding measurements for this variable
	@OneToMany(mappedBy = "met")
	List<Measurement> data;
	
	//constructors
	public Metric(SmartMeter sm, String measvar){
		
		this.measvar = measvar;
		this.sm = sm;
		
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

	public Integer getId() {
		return id;
	}

	public SmartMeter getSm() {
		return sm;
	}
	

}
