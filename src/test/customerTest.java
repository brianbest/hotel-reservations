package test;

import model.Customer;

public class customerTest {

    public static void main(String[] args) {
        assertThatCustomerBuilds();
        assertThatCustomerWillThrowOnInvalidEmail();
    }

    public static void assertThatCustomerBuilds() {
        Customer customer = new Customer("Jon", "Doe", "j@doe.com");
        System.out.println(customer);
    }

    public static void assertThatCustomerWillThrowOnInvalidEmail() {
        try{
            Customer customer = new Customer("Jon", "Doe", "INVALID");
        } catch (IllegalArgumentException ex){
            System.out.println("Worked: " + ex.getLocalizedMessage());
        }
    }
}