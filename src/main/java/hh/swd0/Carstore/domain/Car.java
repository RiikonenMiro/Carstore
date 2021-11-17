package hh.swd0.Carstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private long id;
	private String merkki;
	private String malli;
	private int vuosi;
	private double hinta;
	
	@ManyToOne
	@JoinColumn(name = "tyyppiid")
	private Type type;
	
	public Car() {}
	
	public Car(String merkki, String malli, int vuosi, double hinta, Type type) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.vuosi = vuosi;
		this.hinta = hinta;
		this.type = type;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}

	public String getMerkki() {
		return merkki;
	}

	public String getMalli() {
		return malli;
	}

	public int getVuosi() {
		return vuosi;
	}

	public double getHinta() {
		return hinta;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		if (this.type != null)
			return "Car [id=" + id + ", merkki=" + merkki + ", malli=" + malli + ", vuosi=" + vuosi + ", hinta=" + hinta + "type =" + this.getType() + "]";
		else
			return "Car [id=" + id + ", merkki=" + merkki + ", malli=" + malli + ", vuosi=" + vuosi + ", hinta=" + hinta+ "]";
	}

}
