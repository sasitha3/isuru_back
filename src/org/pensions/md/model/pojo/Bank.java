package org.pensions.md.model.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "bank", uniqueConstraints = {
		@UniqueConstraint(columnNames = "bank_id")
})
public class Bank {

	private int id;
	private String name;
	private List<Branch> branches = new ArrayList<Branch>();
	
	public Bank() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "bank_id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name = "name", length = 30, nullable = false)
	public String getName() {
		return name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.ALL)
	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
