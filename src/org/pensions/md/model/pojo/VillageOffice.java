package org.pensions.md.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "villeage_office", uniqueConstraints = {
		@UniqueConstraint(columnNames = "village_office_id")
})
public class VillageOffice {

	private long id;
	private String name;
	private DSOffice dsOffice;
	
	public VillageOffice() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name = "village_office_id", nullable = false, unique = true)
	public long getId() {
		return id;
	}

	@Column(name = "name", length = 100, nullable = false)
	public String getName() {
		return name;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ds_id", nullable = false)
	public DSOffice getDsOffice() {
		return dsOffice;
	}

	public void setDsOffice(DSOffice dsOffice) {
		this.dsOffice = dsOffice;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
