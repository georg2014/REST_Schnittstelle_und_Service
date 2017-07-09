package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Metric {
	
	//attributes
	Integer id;
	String text;
	Measurements data;
	
	//constructors
	/**
	 * @param text
	 * @param data
	 */
	public Metric(String text, Measurements data) {
		super();
		this.text = text;
		this.data = data;
	}
	public Metric() {
		super();
	}
	
}
