package hh.swd0.Carstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tyyppiid;
	private String kuvaus;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<Car> cars;
	
	public Type() {}
	
	public Type(String kuvaus) {
		super();
		this.kuvaus = kuvaus;
	}

	public void setTyyppiid(long tyyppiid) {
		this.tyyppiid = tyyppiid;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Long getTyyppiid() {
		return tyyppiid;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "Type [tyyppiid=" + tyyppiid + ", kuvaus=" + kuvaus + "]";
	}
	
	
}
