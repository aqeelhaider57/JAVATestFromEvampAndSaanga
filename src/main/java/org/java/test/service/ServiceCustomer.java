package org.java.test.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.java.test.dto.DtoCustomer;
import org.java.test.dto.DtoSim;
import org.java.test.model.Customer;
import org.java.test.model.Sim;
import org.java.test.repository.RepositoryCustomer;
import org.java.test.repository.RepositorySim;
import org.java.test.util.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("serviceCustomer")
public class ServiceCustomer {

	@Autowired
	private RepositoryCustomer repositoryCustomer;
	
	@Autowired
	private RepositorySim repositorySim;
	
	public boolean create(DtoCustomer dtoCustomer) {
		
		boolean result = false;
		if(dtoCustomer != null) {
			repositoryCustomer.saveAndFlush(mapDtoToCustomerEntity(dtoCustomer));
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	//0 0 0 * * ? = Every day at midnight - 12am
	@Scheduled(cron = "0 0 0 * * ?")		//(cron = "0 * * ? * *") = Every 1 minuts
	public void testScheduler() {
		LocalDate localDate = LocalDate.now();
		Period period = Period.ofDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		List<Customer> customers = repositoryCustomer.findByDateOfBirth(LocalDate.parse(formatter.format(localDate.plus(period))));
		customers.stream().forEach(x -> {
			System.out.println(x.getEmail());
		});
		
		System.out.println("customers by date are fetching........");
		for(Customer customer : customers) {
			List<Sim> sim = repositorySim.findByCustomerId(customer.getId());
			String simNumbers = null;
			for(int i = 0; i < sim.size(); i++) {
				Sim getSimNumber = new Sim();
				if(i > 0) {
					getSimNumber = sim.get(i);
					simNumbers = simNumbers+", "+getSimNumber.getSimNumber().toString();
				}else {
					getSimNumber = sim.get(i);
					simNumbers = getSimNumber.getSimNumber().toString();
				}
			}
			String emailBody = "Dear Valuable Customer,"
					+" Wishing you a very happy birthday in advance on "+customer.getDateOfBirth()+" and the number of happiest years ahead,"
					+"we hope our relationship would grow years and years and long good to go, "
					+"we are honored to have a wonderful customer like you. We respect your feelings"
					+" and concerns and your all requests are our command and utmost priority for us."
					+"We hope that we can serve you our best services years and years ahead. Thank you to have faith in us."
					+"Yours sim number/s "
					+simNumbers
					+ " "
					+ "With Best Wishes,\r\n"
					+ "ABC Company";
			
			Email.sendEmail(customer.getEmail(),"Wishing you a very happy birthday.", emailBody);
		}
	}
	
	public List<DtoCustomer> findCustomersByDateOfBirth(){
		LocalDate localDate = LocalDate.now();
		Period period = Period.ofDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		System.out.println(formatter.format(localDate.plus(period)));
		List<Customer> customers = repositoryCustomer.findByDateOfBirth(LocalDate.parse(formatter.format(localDate.plus(period))));
		List<DtoCustomer> dtoCustomers = new ArrayList<>();
		customers.stream().forEach(x -> {
			dtoCustomers.add(new DtoCustomer(x));
		});
		return dtoCustomers;
	}
	
	public List<Customer> findByDateOfBirth(){
		LocalDate localDate = LocalDate.now();
		Period period = Period.ofDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		System.out.println(formatter.format(localDate.plus(period)));
		List<Customer> customers = repositoryCustomer.findByDateOfBirth(LocalDate.parse(formatter.format(localDate.plus(period))));
		List<DtoCustomer> dtoCustomers = new ArrayList<>();
		customers.stream().forEach(x -> {
			dtoCustomers.add(new DtoCustomer(x));
		});
		return customers;
	}
	
	public Customer mapDtoToCustomerEntity(DtoCustomer dtoCustomer) {
		Customer customer = new Customer();
		customer.setName(dtoCustomer.getCustomerName());
		customer.setDateOfBirth(LocalDate.parse(dtoCustomer.getDateOfBirth()));
		return customer;
	}
	
	public Sim mapDtoSimToEntitySim(DtoSim dtoSim) {
		Sim sim = new Sim();
		sim.setSimNumber(dtoSim.getSimNumber());
		return sim;
	}
	
}
