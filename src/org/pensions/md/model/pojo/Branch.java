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

@Entity
@Table(name = "branch", uniqueConstraints = {
		@UniqueConstraint(columnNames = "branch_id")
})
public class Branch {

	private int id;
	private String name;
	private String address;
	private Bank bank;
	private Integer code;
	
	public Branch() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "branch_id",unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name = "name", length = 30, nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "address", length = 100, nullable = false)
	public String getAddress() {
		return address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bankId", nullable = false)
	public Bank getBank() {
		return bank;
	}
	
	@Column(name = "code", nullable = true)
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
