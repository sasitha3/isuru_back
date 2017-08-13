package org.pensions.md.model.response.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SalaryList {
	
	private List<Double> salaries = new ArrayList<>();
	
	public SalaryList() {
		// TODO Auto-generated constructor stub
	}

	public List<Double> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Double> salaries) {
		this.salaries = salaries;
	}
}
