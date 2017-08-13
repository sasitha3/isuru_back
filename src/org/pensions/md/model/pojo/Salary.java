package org.pensions.md.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "salary", uniqueConstraints = {
		@UniqueConstraint(columnNames = "salary_id")
})
@XmlRootElement
public class Salary {

	private Integer id;
	private SalaryScale scale;
	private int step;
	private Double basicSalary;
	private Double grossSalary;
	
	public Salary() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "salary_id", nullable = false, unique = true)
	public Integer getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scale", nullable = false)
	public SalaryScale getScale() {
		System.out.println(scale);
		return scale;
	}

	@Column(name = "step", nullable = false)
	public int getStep() {
		return step;
	}

	@Column(name = "basic_salary", nullable = false, precision = 2)
	public Double getBasicSalary() {
		return basicSalary;
	}

	@Column(name = "gross_salary", nullable = false, precision = 2)
	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setScale(SalaryScale scale) {
		this.scale = scale;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

}
