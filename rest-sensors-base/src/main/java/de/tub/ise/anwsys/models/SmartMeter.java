<<<<<<< HEAD
package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author G St
 *
 */
@Entity
public class SmartMeter {
	
	//attributes
	@Id
	@GeneratedValue
	String id;
	@OneToMany(mappedBy = "text")//TODO mappedBy value not so sure!
	Metric metric;
	 
	//constructors
	/**
	 * @param id
	 * @param metric as Metric
	 */
	public SmartMeter(String id, Metric metric) {
		this.id = id;
		this.metric = metric;
	}
	
	public SmartMeter(){}

	
	//getters and setters

	/**
	 * @return id as String
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id as String
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return as Metric
	 */
	public Metric getMetric() {
		return metric;
	}
	
}
=======
package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author G St
 *
 */
@Entity
public class SmartMeter {
	
	//attributes
	@Id
	@GeneratedValue
	String id;
	@OneToMany(mappedBy = "text")//TODO mappedBy value not so sure!
	Metric metric;
	 
	//constructors
	/**
	 * @param id
	 * @param metric as Metric
	 */
	public SmartMeter(Metric metric) {
		this.metric = metric;
	}
	
	public SmartMeter(){}

	
	//getters and setters

	/**
	 * @return id as String
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id as String
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return as Metric
	 */
	public Metric getMetric() {
		return metric;
	}
	/**
	 * @param metric as Metric
	 */
	public void setMetric(Metric metric) {
		this.metric = metric;
	}
	
}
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10
