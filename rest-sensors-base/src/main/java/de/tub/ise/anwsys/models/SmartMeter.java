package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SmartMeter {

	 @Id
	 String id;

	public SmartMeter(String id) {
		super();
		this.id = id;
	}
	
	public SmartMeter(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
