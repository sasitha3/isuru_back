package org.pensions.md.model.response.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.pensions.md.model.dto.DSOfficeDTO;

@XmlRootElement
public class DSList {
private List<DSOfficeDTO> list = new ArrayList<DSOfficeDTO>();
	
	public DSList() {
		// TODO Auto-generated constructor stub
	}

	public List<DSOfficeDTO> getList() {
		return list;
	}

	public void setList(List<DSOfficeDTO> list) {
		this.list = list;
	}
}
