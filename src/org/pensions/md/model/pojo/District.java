package org.pensions.md.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Table(name = "district", uniqueConstraints = {
		@UniqueConstraint(columnNames = "district_id")
})
@Entity
public class District {
	
	private int id;
	private String name;
	
	public District() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "district_id", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	@Column(name = "district_name", nullable = false, length = 30)
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
