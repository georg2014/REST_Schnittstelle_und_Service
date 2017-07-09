package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SmartMeter implements Serializable {
	
	private static final long serialVersionUID = 7803824012042165639L;

	//attributes
	@Id
	@Column
	String id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sm")
	List<Metric> metric;
	
	//constructors
	public SmartMeter(){}
	
	public SmartMeter(String id){
		this.id = id;
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

	public String getId() {
		return id;
	}

	
}
