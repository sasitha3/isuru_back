package org.pensions.md.model.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "ds_office", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ds_id")
})
public class DSOffice {
	
	private long id;
	private String name;
	private District district;
	private int dsCode;
	private List<VillageOffice> villageOffices = new ArrayList<VillageOffice>();
	
	public DSOffice() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "ds_id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dsOffice", cascade = CascadeType.ALL)
	public List<VillageOffice> getVillageOffices() {
		return villageOffices;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	public District getDistrict() {
		return district;
	}

	@Column(name = "ds_code")
	public int getDsCode() {
		return dsCode;
	}

	public void setDsCode(int dsCode) {
		this.dsCode = dsCode;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public void setVillageOffices(List<VillageOffice> villageOffices) {
		this.villageOffices = villageOffices;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
