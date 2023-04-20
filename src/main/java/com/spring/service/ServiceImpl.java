package com.spring.service;

import java.lang.module.FindException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.AddressDao;
import com.spring.entity.Address;
import com.spring.response.AddressResponse;

@Service
public class ServiceImpl implements AddressService {
	@Autowired
	public AddressDao dao;
	@Autowired
	public ModelMapper mapper;

	@Override
	public AddressResponse addessById(int addressId) {
		Optional<Address> findById = dao.findById(addressId);
		if (findById.isPresent()) {
			Address address = findById.get();
			AddressResponse response = mapper.map(address, AddressResponse.class);
			System.out.println(response + "+++++++++++++++");
			return response;

		} else {
			System.out.println("specified id is not existed.....");
			return null;
		}

	}

	@Override
	public List<AddressResponse> getAllAddresses() {
		List<Address> findAll = dao.findAll();
		List<AddressResponse> allData = findAll.stream().map(address -> mapper.map(address, AddressResponse.class))
				.collect(Collectors.toList());
		// System.out.println(allData+"----------------------");
		return allData;

	}

	@Override
	public AddressResponse getAddressByCustId(int custId) {
		Address findAddressByCustomerId = dao.findAddressByCustomerId(custId);
		AddressResponse address = mapper.map(findAddressByCustomerId,AddressResponse.class);
		System.out.println(address);
		return address;
	}

}
