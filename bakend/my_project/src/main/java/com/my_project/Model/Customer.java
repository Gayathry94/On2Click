package com.my_project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	private String id;
	@NotBlank(message = "FirstName Required")
	@Column(name="First_Name")
	private String fname;
	@NotBlank(message = "LastName Required")
	@Column(name="Last_Name")
	private String lname;
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
	@NotBlank(message = "OTP Required")
	@Column(name="OTP")
	private String otp;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
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
	 @AssertTrue(message = "Password and confirm password must match")
	    private boolean isPasswordConfirmed() {
	        return pass != null && pass.equals(conp);
	 }
}
