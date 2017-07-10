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
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.AUTO)
	long metId;
=======
	@GeneratedValue
<<<<<<< HEAD
	String metId;
=======
	@Column
	String metricId;
>>>>>>> branch 'GeorgsBranchPlayAround1ToModelAfterClassDiagramm10' of https://github.com/georg2014/REST_Schnittstelle_und_Service.git
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
	
	//The measured variable
	@Column
	String measvar;
	
<<<<<<< HEAD
	//Reference to the corresponding Smart Meters
	@JsonIgnore
	@ManyToMany(mappedBy="metric")
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

<<<<<<< HEAD
	public long getMetId() {
=======
<<<<<<< HEAD
	public String getMetId() {
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
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
