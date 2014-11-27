package cn.chinattclub.izou7AppServer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "i_province")
public class Province {
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
	private List<City> city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
	
	
}
