package de.tub.ise.anwsys.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "smartmeter")
public class SmartMeter implements Serializable {
	
	private static final long serialVersionUID = 7803824012042165639L;

	//attributes
	@Id
	@Column
	String meterId;
	
	//metrics for this meter
	@ManyToMany
	@JoinTable
	List<Metric> metric;
	
	//measurements for this meter
	@JsonIgnore
	@OneToMany(mappedBy="smart")
	@Column(name="meas")
	List<Measurement> meas;
	
	//constructors
	public SmartMeter(){}
	
	public SmartMeter(String smId, List<Metric> metric){
		this.meterId = smId;
		this.metric = metric;
	}
	
	//getter setters
	public List<Metric> getMetric() {
		return metric;
	}

	public List<Measurement> getMeas() {
		return meas;
	}

	public void setMeas(List<Measurement> meas) {
		this.meas = meas;
	}

	public void setMetric(List<Metric> metric) {
		this.metric = metric;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMeterId() {
		return meterId;
	}

	
}
