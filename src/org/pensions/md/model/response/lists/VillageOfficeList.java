package org.pensions.md.model.response.lists;

import java.util.ArrayList;
import java.util.List;

import org.pensions.md.model.dto.VillageOfficeDTO;

public class VillageOfficeList {
private List<VillageOfficeDTO> list = new ArrayList<VillageOfficeDTO>();
	
	public VillageOfficeList() {
		// TODO Auto-generated constructor stub
	}

	public List<VillageOfficeDTO> getList() {
		return list;
	}

	public void setList(List<VillageOfficeDTO> list) {
		this.list = list;
	}
}
