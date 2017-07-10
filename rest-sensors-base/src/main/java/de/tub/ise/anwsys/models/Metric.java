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
	@GeneratedValue
<<<<<<< HEAD
	String metId;
=======
	@Column
	String metricId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	
	//The measured variable
	String measvar;
	
<<<<<<< HEAD
	//Reference to the corresponding Smart Meters
	@JsonIgnore
	@ManyToMany
	@JoinTable
	List<SmartMeter> sm;
=======
	//Reference to the corresponding Smart Meter
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	SmartMeter sm;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	
	//Reference to the corresponding measurements for this variable
	@JsonIgnore
	@OneToMany(mappedBy = "met")
	List<Measurement> data;
	
	//constructors
	public Metric(List<SmartMeter> sm, String measvar){
		
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

<<<<<<< HEAD
	public String getMetId() {
		return metId;
=======
	public String getId() {
		return metricId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
	}

	public List<SmartMeter> getSm() {
		return sm;
	}
	
}
