package com.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@Column(name = "address_id")
	private Integer addressId;
	@Column(name = "street")
	private String street;
	@Column(name = "dist_name")
	private String district;
	@Column(name = "street_pin")
	private int pin;

}
