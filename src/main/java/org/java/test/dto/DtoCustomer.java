package org.java.test.dto;

import java.util.Date;

import org.java.test.model.Customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DtoCustomer {

	private Integer id;
	private String customerName;
	private String email;
	private String dateOfBirth;

	public DtoCustomer() {
		super();
	}

	public DtoCustomer(Integer id, String customerName, String dateOfBirth) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
	}

	public DtoCustomer(String customerName, String dateOfBirth) {
		super();
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
	}

	public DtoCustomer(Customer customer) {
		super();
		this.id = customer.getId();
		this.customerName = customer.getName();
		this.dateOfBirth = customer.getDateOfBirth().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
