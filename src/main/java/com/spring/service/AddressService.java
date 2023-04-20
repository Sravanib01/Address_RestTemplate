package com.spring.service;

import java.util.List;

import com.spring.entity.Address;
import com.spring.response.AddressResponse;

public interface AddressService {
	
	
	public AddressResponse addessById(int addressId);
	public List<AddressResponse>  getAllAddresses();
	public AddressResponse getAddressByCustId(int custId);

}
