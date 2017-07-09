package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SmartMeter implements Serializable {
	
	private static final long serialVersionUID = 7803824012042165639L;

	//attributes
	@Id
	String meterId;
	
	@JsonIgnore
	@ManyToMany(mappedBy="sm")
	List<Metric> metric;
	
	@OneToMany(mappedBy="smart")
	List<Measurement> meas;
	
	//constructors
	public SmartMeter(){}
	
	public SmartMeter(String smId){
		this.meterId = smId;
	}
	
	//getter setters
	public List<Metric> getMetric() {
		return metric;
	}

	public void setMetric(List<Metric> metric) {
		this.metric = metric;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSmId() {
		return meterId;
	}

	
}
