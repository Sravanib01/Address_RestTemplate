package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Address;
import com.spring.response.AddressResponse;
import com.spring.service.ServiceImpl;

@RestController
@RequestMapping("/addressdata")
public class AddressController {
	@Autowired
	public ServiceImpl service;

	@GetMapping(value = "/getById/{addressId}", produces = "application/json")
	public ResponseEntity<?> getAddressByAddId(@PathVariable("addressId") int addressId) {
		AddressResponse addById = service.addessById(addressId);
		return new ResponseEntity<>(addById, HttpStatus.OK);
	}

	@GetMapping("/getAllData")
	public ResponseEntity<List<?>> getAllAddressData() {
		List<AddressResponse> allAddresses = service.getAllAddresses();
		return new ResponseEntity<>(allAddresses, HttpStatus.OK);
	}

	@GetMapping(value = "/getByCustId/{custId}", produces = "application/json")
	public ResponseEntity<?> getCustomersByCustId(@PathVariable("custId") int custId) {
		AddressResponse addressByCustId = service.getAddressByCustId(custId);
		return new ResponseEntity<>(addressByCustId,HttpStatus.OK);
	}
}
