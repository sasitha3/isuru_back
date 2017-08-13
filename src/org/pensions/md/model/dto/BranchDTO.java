package org.pensions.md.model.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BranchDTO {

	private int id;
	private String name;
	private String address;
	private BankDTO bank;
	private int code;
	
	public BranchDTO() {
		
	}
	
	
	public BranchDTO(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAddress() {
		return address;
	}


	public BankDTO getBank() {
		return bank;
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


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public void setBank(BankDTO bank) {
		this.bank = bank;
	}

	
}
