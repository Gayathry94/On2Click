package com.my_project.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Registration")
public class Registration {
	

	@Id
	@Column(name="Cid")
	private String cid;
	@NotBlank(message = "FullName Required")
	@Column(name="Name")
	private String name;

	@NotBlank(message = "Please specify which category you belongs")
	@Column(name="Type_of_Customer")
	private String tc;
	
	@NotBlank(message = "Address Required")
	@Column(name="Address")
	private String address;
	
	@NotBlank(message = "Landmark Required")
	@Column(name="Landmark")
	private String landmark;
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true) 
	private String mailid;
	  @NotBlank(message = "Phone number is required")
	    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 characters")
	    @Pattern(regexp = "\\d{10,12}", message = "Phone number must contain only digits")
	@Column(name="Phone_NO")
	private String phone;
	@NotBlank(message = "Aadhar Required")
	@Column(name="Aadhar_NO")
	private String adhar;
	@NotBlank(message = "UserName Required")
	@Column(name="User_Name")
	private String uname;
	@NotBlank(message = "Password Required")
	@Column(name="Password")
	private String pass;
	@NotBlank(message = "Confirm Password Required")
	@Column(name="Confirm_Password")
	private String conp;
	
	@Column(name="Date")
	private String date;
	@Column(name="Time")
	private String time;
	@NotBlank(message = "OTP Required")
	@Column(name="OTP")
	private String otp;
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getConp() {
		return conp;
	}
	public void setConp(String conp) {
		this.conp = conp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Registration() {

	}
	@AssertTrue(message = "Password and confirm password must match")
    private boolean isPasswordConfirmed() {
        return pass != null && pass.equals(conp);
 }
	
	


	}


