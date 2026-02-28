package tripease.example.TripEase.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tripease.example.TripEase.Enum.Gender;
import tripease.example.TripEase.dtos.requests.CustomerReqdtos;
import tripease.example.TripEase.dtos.responses.CustomerResdtos;
import tripease.example.TripEase.entity.Customer;
import tripease.example.TripEase.exceptions.CustomerNotFoundException;
import tripease.example.TripEase.repository.CustomerRepository;
import tripease.example.TripEase.transformer.CustomerTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResdtos addCustomer(CustomerReqdtos customerReqdtos) {

        Customer customer = CustomerTransformer.customerReqtoCustomer(customerReqdtos);
        Customer savedcustomer =  customerRepository.save(customer);

       CustomerResdtos customerResdtos = CustomerTransformer.customertoCustomerResdtos(savedcustomer);
        return customerResdtos;
    }

    public CustomerResdtos getCustomerById(int id) {
        Optional<Customer> optionalcustomer = customerRepository.findById(id);
        if(optionalcustomer.isEmpty()){
            throw new CustomerNotFoundException("Id is not valid");

        }
        CustomerResdtos customerResdtos = CustomerTransformer.customertoCustomerResdtos(optionalcustomer.get());
        return customerResdtos;
    }


    public List<CustomerResdtos> getCustomerByGender(Gender gender) {
        List<Customer> customerList = customerRepository.findByGender(gender);
        List<CustomerResdtos> customerResdtos = new ArrayList<>();
        for(Customer customer : customerList){
             customerResdtos.add(CustomerTransformer.customertoCustomerResdtos(customer));

        }
        return customerResdtos;
    }

    public List<CustomerResdtos> getCustomerByGenderAndAge(Gender gender, int age) {
        List<Customer> customerList = customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResdtos> customerResdtos = new ArrayList<>();
        for(Customer customer:customerList){
            customerResdtos.add(CustomerTransformer.customertoCustomerResdtos(customer));
        }
        return customerResdtos;
    }

    public List<CustomerResdtos> getCustomerWithAgeCond(int age) {
        List<Customer> customerList = customerRepository.getCustomerWithAgecond(age);
        List<CustomerResdtos> customerResdtos = new ArrayList<>();
        for(Customer customer:customerList){
            customerResdtos.add(CustomerTransformer.customertoCustomerResdtos(customer));
        }
        return customerResdtos;
    }
}
