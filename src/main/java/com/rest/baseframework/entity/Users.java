package com.rest.baseframework.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String user_name;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String middle_name;
	@Column
	private String name_of_farm;
	@Column
	private String firm_type;
	@Column
	private String pan;
	@Column
	private String gstn;
	@Column
	private String address_line1;
	@Column
	private String address_line2;
	@Column
	private String city;
	@Column
	private String district;
	@Column
	private String state;
	@Column
	private String pin;
	@Column(unique = true)
	private String mobile;
	@Column(unique = true)
	private String landline;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String aadhar;
	@Column
	private String password;
	@Column
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@Column
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	@Column
	private Boolean del_ind;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getName_of_farm() {
		return name_of_farm;
	}
	public void setName_of_farm(String name_of_farm) {
		this.name_of_farm = name_of_farm;
	}
	public String getFirm_type() {
		return firm_type;
	}
	public void setFirm_type(String firm_type) {
		this.firm_type = firm_type;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public Boolean getDel_ind() {
		return del_ind;
	}
	public void setDel_ind(Boolean del_ind) {
		this.del_ind = del_ind;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}




