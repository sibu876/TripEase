package tripease.example.TripEase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tripease.example.TripEase.Enum.Gender;
import tripease.example.TripEase.dtos.requests.CustomerReqdtos;

import tripease.example.TripEase.dtos.responses.CustomerResdtos;
import tripease.example.TripEase.services.CustomerServices;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CusomerController {

    @Autowired
    CustomerServices customerServices;

    @PostMapping("/add")
    public CustomerResdtos addCustomer(@RequestBody CustomerReqdtos customerReqdtos){
        return customerServices.addCustomer(customerReqdtos);
    }

    @GetMapping("/get/{id}")
    public CustomerResdtos getCustomerById(@PathVariable int id){
        return customerServices.getCustomerById(id);
    }

    @GetMapping("/get/{gender}")
    public List<CustomerResdtos> getCustomerByGender(@PathVariable Gender gender){
        return customerServices.getCustomerByGender(gender);
    }

    @GetMapping("get/{gender}/{age}")
    public List<CustomerResdtos> getCustomerByGenderAndAge(@PathVariable Gender gender, @PathVariable int age){
        return customerServices.getCustomerByGenderAndAge(gender,age);
    }

    @GetMapping("get/byage/{age}")
    public List<CustomerResdtos> getCustomerWithAgeCond(@PathVariable int age){
        return customerServices.getCustomerWithAgeCond(age);
    }

}
