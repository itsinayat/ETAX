package com.rest.baseframework.service.impl;

import com.rest.baseframework.entity.Users;
import com.rest.baseframework.model.UsersTO;

public class UserTranslator {
	
	public static UsersTO entitytoModel(Users users) {
		UsersTO userTO=new UsersTO();
		userTO.setAadhar(users.getAadhar());
		userTO.setAddress_line1(users.getAddress_line1());
		userTO.setAddress_line2(users.getAddress_line2());
		userTO.setCity(users.getCity());
		userTO.setCreateDateTime(users.getCreateDateTime());
		userTO.setDel_ind(users.getDel_ind());
		userTO.setDistrict(users.getDistrict());
		userTO.setEmail(users.getEmail());
		userTO.setFirm_type(users.getFirm_type());
		userTO.setFirst_name(users.getFirst_name());
		userTO.setGstn(users.getGstn());
		userTO.setId(users.getId());
		userTO.setLandline(users.getLandline());
		userTO.setLast_name(users.getLast_name());
		userTO.setMiddle_name(users.getMiddle_name());
		userTO.setMobile(users.getMobile());
		userTO.setName_of_farm(users.getName_of_farm());
		userTO.setPan(users.getPan());
		userTO.setPassword(users.getPassword());
		userTO.setPin(users.getPin());
		userTO.setState(users.getState());
		userTO.setUpdateDateTime(users.getUpdateDateTime());
		return userTO;
		
	}
	
	public static Users ModelToEntity(UsersTO userTo) {

		Users user=new Users();
		user.setAadhar(userTo.getAadhar());
		user.setAddress_line1(userTo.getAddress_line1());
		user.setAddress_line2(userTo.getAddress_line2());
		user.setCity(userTo.getCity());
		user.setCreateDateTime(userTo.getCreateDateTime());
		user.setDel_ind(userTo.getDel_ind());
		user.setDistrict(userTo.getDistrict());
		user.setEmail(userTo.getEmail());
		user.setFirm_type(userTo.getFirm_type());
		user.setFirst_name(userTo.getFirst_name());
		user.setGstn(userTo.getGstn());
		user.setLandline(userTo.getLandline());
		user.setLast_name(userTo.getLast_name());
		user.setMiddle_name(userTo.getMiddle_name());
		user.setMobile(userTo.getMobile());
		user.setName_of_farm(userTo.getName_of_farm());
		user.setPan(userTo.getPan());
		user.setPassword(userTo.getPassword());
		user.setPin(userTo.getPin());
		user.setState(userTo.getState());
		user.setUpdateDateTime(userTo.getUpdateDateTime());
		return user;
		
	
		
	}

}
