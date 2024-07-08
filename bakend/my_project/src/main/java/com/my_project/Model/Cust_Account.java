package com.my_project.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cust_Account {
	@Id
	private String cid;
	//@NotBlank(message="Please Enter the UPID")
	@Column(name="UPID")
	private String upid;
	//@NotBlank(message="Please Enter the Card Number")
	@Column(name="CARD_NO")
	private String cardno;
	//@NotBlank(message="Please Enter the CVV Number")
	@Column(name="CVV")
	private String cvv;
	//@NotBlank(message="Please Enter the Validity")
	@Column(name="VALIDITY")
	private String validity;
	//@NotBlank(message="Please Enter the OTP")
	@Column(name="OTP")
	private String otp;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Customer rt;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUpid() {
		return upid;
	}
	public void setUpid(String upid) {
		this.upid = upid;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Cust_Account [cid=" + cid + ", upid=" + upid + ", cardno=" + cardno + ", cvv=" + cvv + ", validity="
				+ validity + ", otp=" + otp + "]";
	}
	
	

}
