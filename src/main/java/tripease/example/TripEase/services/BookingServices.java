package tripease.example.TripEase.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tripease.example.TripEase.dtos.requests.BookingReqdtos;
import tripease.example.TripEase.dtos.responses.BookingResdtos;
import tripease.example.TripEase.entity.Booking;
import tripease.example.TripEase.entity.Cab;
import tripease.example.TripEase.entity.Customer;
import tripease.example.TripEase.entity.Driver;
import tripease.example.TripEase.exceptions.CabNotAvailableException;
import tripease.example.TripEase.exceptions.CustomerNotFoundException;
import tripease.example.TripEase.repository.BookingRepository;
import tripease.example.TripEase.repository.CabRepository;
import tripease.example.TripEase.repository.CustomerRepository;
import tripease.example.TripEase.repository.DriverRepository;
import tripease.example.TripEase.transformer.BookingTransformer;

import java.util.Optional;

@Service
public class BookingServices {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResdtos bookCab(BookingReqdtos bookingReqdtos,int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Customer customer = optionalCustomer.get();
         Cab avialablecab = cabRepository.getAvailableCab();
         if(avialablecab == null){
             throw new CabNotAvailableException("Sorry Currentrly all cab is busy");
         }
        Booking booking = BookingTransformer.bookingReqdtosToBooking(bookingReqdtos,avialablecab.getPerkmrate());
         Booking savedbbooking = bookingRepository.save(booking);
        customer.getBookings().add(savedbbooking);
        avialablecab.setAvailable(false);
        Driver  driver = driverRepository.getDriverfromcabid(avialablecab.getCabId());
        driver.getBookings().add(savedbbooking);

       Customer savedCustomer =  customerRepository.save(customer);
       Driver Saveddriver =  driverRepository.save(driver);

       sendEmail(savedCustomer);
        return BookingTransformer.bookingTobookingResdtos(savedbbooking,savedCustomer,avialablecab,Saveddriver);
    }

    @Value("${MAIL_USERNAME}")
    private String mailUsername;

    private void sendEmail(Customer customer){
        String text = "Your Cab has beenn booked \n Thank You For choosing TripEase";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailUsername);
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("Cab Booked");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
