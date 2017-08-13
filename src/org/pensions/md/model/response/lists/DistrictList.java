package org.pensions.md.model.response.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.pensions.md.model.dto.DistrictDTO;

@XmlRootElement
public class DistrictList {

	private List<DistrictDTO> list = new ArrayList<DistrictDTO>();
	
	public DistrictList() {
		// TODO Auto-generated constructor stub
	}

	public List<DistrictDTO> getList() {
		return list;
	}

	public void setList(List<DistrictDTO> list) {
		this.list = list;
	}
}
