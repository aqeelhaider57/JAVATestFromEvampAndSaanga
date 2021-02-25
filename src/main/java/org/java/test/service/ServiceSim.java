package org.java.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.java.test.dto.DtoSim;
import org.java.test.model.Customer;
import org.java.test.model.Sim;
import org.java.test.repository.RepositoryCustomer;
import org.java.test.repository.RepositorySim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceSim")
public class ServiceSim {

	@Autowired
	private RepositorySim repositorySim;
	
	@Autowired
	private RepositoryCustomer repositoryCustomer;
	
	public boolean create(DtoSim dtoSim) {
		if (dtoSim != null) {
			repositorySim.saveAndFlush(mapDtoSimToEntitySim(dtoSim));
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean updateSimForCustomer(DtoSim dtoSim) {
		Sim sim = null;
		if (dtoSim.getId() != null) {
		Optional<Sim> optional =	repositorySim.findById(dtoSim.getId());
			if (!optional.isEmpty()) {
				sim = optional.get();
			Optional<Customer> customer = repositoryCustomer.findById(dtoSim.getCustomerId());
			if(!customer.isEmpty())
				sim.setCustomer(customer.get());
			}
			
			if(sim.getCustomer().getId() != null) {
			repositorySim.saveAndFlush(sim);
			return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public List<DtoSim> getAll(){
		List<Sim> sims = repositorySim.findAll();
		List<DtoSim> dtoSims = new ArrayList<>();
		sims.stream().forEach(sim ->{
			dtoSims.add(new DtoSim(sim));
		});
		return dtoSims;
	}
	
	public List<DtoSim> findByCustomerId(DtoSim dtoSim){
		List<Sim> sims = repositorySim.findByCustomerId(dtoSim.getCustomerId());
		List<DtoSim> dtoSims = new ArrayList<>();
		sims.stream().forEach(sim ->{
			dtoSims.add(new DtoSim(sim));
		});
		return dtoSims;
	}
	
	public List<Sim> getByCustomerId(Integer customerId){
		List<Sim> sims = repositorySim.findByCustomerId(customerId);
		return sims;
	}
	
	public Sim mapDtoSimToEntitySim(DtoSim dtoSim) {
		Sim sim = new Sim();
		sim.setSimNumber(dtoSim.getSimNumber());
		return sim;
	}
}
