package com.my_project.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Accounts {
	@Id
	@Column(name="ID")

	private String id;
	@NotBlank(message="Please Enter the Account Number")
	@Column(name="Account_Number")
	private String acno;
	@NotBlank(message="Please Enter the State")
	@Column(name="State")
	private String state;
	@NotBlank(message="Please Enter the Branch")
	@Column(name="Branch")
	private String branch;
	@NotBlank(message="Please Enter the IFSC code")
	@Column(name="IFSC")
	private String ifsc;
	@NotBlank(message="Please Enter the UPID")
	@Column(name="UPID")
	private String Upid;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Registration rt;

	public Accounts() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getUpid() {
		return Upid;
	}
	public void setUpid(String upid) {
		Upid = upid;
	}
	
	
	

}
