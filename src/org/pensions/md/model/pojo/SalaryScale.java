package org.pensions.md.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "salary_scale", uniqueConstraints = {
		@UniqueConstraint(columnNames = "scale_code")
})
public class SalaryScale {

	private String code;
	private String scale;
	private String grade;
	private String circular;
	
	public SalaryScale() {
		
	}
	
	

	public SalaryScale(String scale, String grade, String circular) {
		super();
		this.scale = scale;
		this.grade = grade;
		this.circular = circular;
	}



	@Id
	@Column(name = "scale_code", unique = true, nullable = false, length = 100)
	public String getCode() {
		this.code = this.scale + "-" + this.circular + "-" + this.grade;
		return code;
	}

	@Column(name = "scale", nullable = false, length = 20)
	public String getScale() {
		return scale;
	}

	@Column(name = "grade", nullable = false, length = 20)
	public String getGrade() {
		return grade;
	}

	@Column(name = "circular", nullable = false, length = 20)
	public String getCircular() {
		return circular;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setCircular(String circular) {
		this.circular = circular;
	}
	
}
