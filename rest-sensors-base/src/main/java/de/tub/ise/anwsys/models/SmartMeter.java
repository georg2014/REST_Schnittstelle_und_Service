package de.tub.ise.anwsys.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmartMeter {

	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private long id;
	 private String kennung;
	 private double maxBelastung;
	 private int spannung;
	 private int stromstärke;
	 
	 
	protected SmartMeter(){}
	public SmartMeter(String kennung){
		this.kennung = kennung;
	}
	
	public SmartMeter(String kennung, int spannung, int stromstärke) {
		this.kennung = kennung;
		this.maxBelastung = 100;
		this.spannung = spannung;
		this.stromstärke = stromstärke;
	}
	
	public double getMaxBelastung() {
		return maxBelastung;
	}

	public void setMaxBelastung(double maxBelastung) {
		this.maxBelastung = maxBelastung;
	}

	public int getSpannung() {
		return spannung;
	}

	public void setSpannung(int spannung) {
		this.spannung = spannung;
	}

	public int getStromstärke() {
		return stromstärke;
	}

	public void setStromstärke(int stromstärke) {
		this.stromstärke = stromstärke;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKennung() {
		return kennung;
	}
	public void setKennung(String kennung) {
		this.kennung = kennung;
	}
}
