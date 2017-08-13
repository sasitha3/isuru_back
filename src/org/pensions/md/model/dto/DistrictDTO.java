package org.pensions.md.model.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DistrictDTO {

	private Integer id;
	private String name;

	public DistrictDTO() {
		// TODO Auto-generated constructor stub
	}

	public DistrictDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

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
