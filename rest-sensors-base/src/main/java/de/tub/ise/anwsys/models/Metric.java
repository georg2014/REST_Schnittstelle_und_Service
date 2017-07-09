package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author G St
 *
 */
@Entity
public class Metric {
	
	//attributes
	@Id
	@GeneratedValue
	Integer id;
	String text;
	Measurements data;
	
	//constructors
	/**
	 * @param text as String
	 * @param data as Measurements
	 */
	public Metric(String text, Measurements data) {
		this.text = text;
		this.data = data;
	}
	public Metric() {
	}

	//getters and setters
	/**
	 * @return as String
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text as String
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return as Measurements
	 */
	public Measurements getData() {
		return data;
	}
	/**
	 * @param data as Measurements
	 */
	public void setData(Measurements data) {
		this.data = data;
	}
}
