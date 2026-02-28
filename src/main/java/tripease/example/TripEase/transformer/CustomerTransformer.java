package tripease.example.TripEase.transformer;

import tripease.example.TripEase.dtos.requests.CustomerReqdtos;
import tripease.example.TripEase.dtos.responses.CustomerResdtos;
import tripease.example.TripEase.entity.Customer;

public class CustomerTransformer {

    public static Customer customerReqtoCustomer(CustomerReqdtos customerReqdtos){
        Customer customer = Customer.builder()
                .name(customerReqdtos.getName())
                .age(customerReqdtos.getAge())
                .emailId(customerReqdtos.getEmailId())
                .gender(customerReqdtos.getGender()).build();
        return customer;
    }
    public static CustomerResdtos customertoCustomerResdtos(Customer customer){

        CustomerResdtos customerResdtos = CustomerResdtos.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .emailId(customer.getEmailId()).build();
        return customerResdtos;
    }
}
