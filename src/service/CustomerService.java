package service;

import exception.DuplicateEmailException;
import model.Customer;
import model.Reservation;

import java.util.Collection;
import java.util.HashMap;

public class CustomerService {
    private static final HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private static Customer currentUser = null;

    public static void addCustomer (String email, String firstName, String lastName) throws DuplicateEmailException {
        if (customers.get(email) != null) {
            throw new DuplicateEmailException();
        }
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        return customers.values();
    }

    public static void setCurrentUserCurrentUser(Customer user) {
        currentUser = user;
    }

    public static Customer getCurrentUser(){
        return currentUser;
    }
}
