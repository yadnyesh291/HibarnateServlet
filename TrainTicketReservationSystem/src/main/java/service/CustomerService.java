package service;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
	 private CustomerDAO customerDAO = new CustomerDAO();

	    public boolean registerCustomer(String name, String mobile, int age, String sex) {
	        Customer customer = new Customer(name, mobile, age, sex);
	        return customerDAO.addCustomer(customer);
	    }

}
