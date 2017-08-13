package org.pensions.md.model.response.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.pensions.md.model.dto.BranchDTO;

@XmlRootElement
public class BranchList {

	private List<BranchDTO> branchs = new ArrayList<BranchDTO>();
	
	public BranchList() {
		// TODO Auto-generated constructor stub
	}

	public List<BranchDTO> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<BranchDTO> branchs) {
		this.branchs = branchs;
	}

}
