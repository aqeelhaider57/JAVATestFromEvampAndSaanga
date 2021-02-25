package org.java.test.dto;

import org.java.test.model.Sim;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DtoSim {

	private Integer id;
	private Integer simNumber;
	private Integer customerId;
	private DtoCustomer dtoCustomer;
	
	public DtoSim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtoSim(Integer id, Integer simNumber, Integer customerId) {
		super();
		this.id = id;
		this.simNumber = simNumber;
		this.customerId = customerId;
	}
	
	public DtoSim(Integer simNumber) {
		this.simNumber = simNumber;
	}
	
	public DtoSim(Sim sim) {
		super();
		this.id = sim.getId();
		this.simNumber = sim.getSimNumber();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public DtoCustomer getDtoCustomer() {
		return dtoCustomer;
	}
	public void setDtoCustomer(DtoCustomer dtoCustomer) {
		this.dtoCustomer = dtoCustomer;
	}
	public Integer getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(Integer simNumber) {
		this.simNumber = simNumber;
	}
	
}
