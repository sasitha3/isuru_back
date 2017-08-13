package org.pensions.md.model.dto;


public class SalaryDTO {

	private double firstAllowance;
	private double secondAllowance;
	private int step;
	private Double basicSalary;
	
	public SalaryDTO() {
		// TODO Auto-generated constructor stub
	}

	public double getFirstAllowance() {
		return firstAllowance;
	}

	public double getSecondAllowance() {
		return secondAllowance;
	}

	public void setFirstAllowance(double firstAllowance) {
		this.firstAllowance = firstAllowance;
	}

	public void setSecondAllowance(double secondAllowance) {
		this.secondAllowance = secondAllowance;
	}

	public int getStep() {
		return step;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
}
