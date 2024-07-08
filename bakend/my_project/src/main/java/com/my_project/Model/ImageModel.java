package com.my_project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ImageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cid;
	private String name;
	private String Type;
@Column(length=500000000)
	private byte[] picByte;






public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public byte[] getPicByte() {
	return picByte;
}
public void setPicByte(byte[] picByte) {
	this.picByte = picByte;
}

public ImageModel() {
	
}
public ImageModel(String name, String type, byte[] picByte) {
	super();
	
	this.name = name;
	Type = type;
	this.picByte = picByte;
}
	
	
	
	

}
