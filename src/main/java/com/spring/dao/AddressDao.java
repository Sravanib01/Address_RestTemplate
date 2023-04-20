package com.spring.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Serializable>{
	@Query(value = "select ad.address_id,ad.street,ad.dist_name,ad.street_pin from customers_dataa cs inner join address ad on cs.cust_id = ad.cust_id where ad.cust_id=:custId",nativeQuery = true)
	public Address findAddressByCustomerId(@Param("custId") int custId);

}


