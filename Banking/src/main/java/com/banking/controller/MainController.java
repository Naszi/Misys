package com.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.dao.AccountDAO;
import com.banking.dao.AllCustomerDAO;
import com.banking.dao.BankStatisticsDAO;
import com.banking.dao.CustomerDAO;
import com.banking.dto.AccountDTO;
import com.banking.dto.AllCustomerDTO;
import com.banking.dto.BankStatisticsDTO;
import com.banking.dto.CustomerDTO;

@Controller
public class MainController {

	private AllCustomerDAO allCustomerDAO = new AllCustomerDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	private AccountDAO accountDAO = new AccountDAO();
	private BankStatisticsDAO bankStatisticsDAO = new BankStatisticsDAO();

	// Managed Customers

	@RequestMapping(value = "/listAllCustomer")
	public ResponseEntity<List<AllCustomerDTO>> listAllCustomer() {

		List<AllCustomerDTO> customers = allCustomerDAO.readAll();

		if (customers == null || customers.isEmpty()) {
			return new ResponseEntity<List<AllCustomerDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AllCustomerDTO>>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/searchCustomer/{id}")
	public ResponseEntity<CustomerDTO> readCustomer(@PathVariable("id") String id) {

		CustomerDTO searchCustomer = customerDAO.read(id);

		return new ResponseEntity<CustomerDTO>(searchCustomer, HttpStatus.OK);
	}

	@PostMapping(value = "/addNewCustomer")
	public ResponseEntity<CustomerDTO> addNewCustomer(@RequestBody CustomerDTO customer) {

		customerDAO.create(customer);

		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}

	@PostMapping(value = "/addNewAccount")
	public ResponseEntity<AccountDTO> addNewAccount(@RequestBody AccountDTO accoun) {

		accountDAO.create(accoun);

		return new ResponseEntity<AccountDTO>(HttpStatus.OK);
	}

	@PostMapping(value = "/editCustomer")
	public ResponseEntity<CustomerDTO> editCustomer(@RequestBody CustomerDTO customer) {

		customerDAO.update(customer);

		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteCustomer/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") String id) {

		customerDAO.delete(id);

		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}

	// Managed Money

	@RequestMapping(value="/withDrawMoney")
	public ResponseEntity<Object> withDrawMoney(HttpServletRequest request) {
		System.out.println("accountnr: " + request.getParameter("accountnr") );
		System.out.println("amount: " + request.getParameter("amount"));
	return new ResponseEntity<Object>(HttpStatus.OK);
	}
	//
	// Bank Statistics

	@RequestMapping(value = "/numberOfCustomers")
	public ResponseEntity<BankStatisticsDTO> numberOfCustomers() {

		return new ResponseEntity<BankStatisticsDTO>(bankStatisticsDAO.numberOfCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/numberOfAccount")
	public ResponseEntity<BankStatisticsDTO> numberOfaccount() {

		bankStatisticsDAO.numberOfAccount();

		return new ResponseEntity<BankStatisticsDTO>(HttpStatus.OK);
	}

}