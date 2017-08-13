package org.pensions.md.model.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.pensions.md.model.pojo.District;

@XmlRootElement
public class DSOfficeDTO {
	
	private long id;
	private String name;
	private District district;
	private int dsCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public int getDsCode() {
		return dsCode;
	}
	public void setDsCode(int dsCode) {
		this.dsCode = dsCode;
	}
	
}
