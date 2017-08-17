package com.ilw.mvcapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilw.mvcapp.config.AppConfig;
import com.ilw.mvcapp.model.Customer;
import com.ilw.mvcapp.rest.dto.StatusDTO;
import com.ilw.mvcapp.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
    AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
    
	private CustomerService customerService = context.getBean(CustomerService.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/customer" }, method = RequestMethod.GET)
	public String homeRequest(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "redirect:customer";
	}
	
	@GetMapping("/{customerID}")
	public Customer getCustomer(@PathVariable("customerID") long customerID) {
		System.out.println(customerService.getCustomer(customerID));
		return customerService.getCustomer(customerID);
	}
	
	@CrossOrigin(origins = "http://www.todolist.com:8080", maxAge = 3600)
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Customer> allCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Customer editCustomer(@RequestBody Customer customer){
		customer = customerService.updateCustomer(customer);
		return customer; 
	}
	
	@CrossOrigin(origins = "http://www.todolist.com:8080", maxAge = 3600)
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer){
		customer = customerService.addCustomer(customer);
		return "customer";
	}
	 
	@RequestMapping(value="/delete/{customerID}",method=RequestMethod.GET)
	public StatusDTO delete(@PathVariable("customerID") long customerID){
		customerService.deleteCustomer(customerID);
		StatusDTO status = new StatusDTO();
		status.setMessage("Customer Deleted Successfully");
		status.setStatus(200);
		return status;
	}
}
