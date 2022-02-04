package service;

import model.Customer;
import model.Reservation;

import java.util.Collection;
import java.util.HashMap;

public class CustomerService {
    public static HashMap<String, Customer> customers = new HashMap<String, Customer>();

    public static void addCustomer (String email, String firstName, String lastName){
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        return customers.values();
    }
}
