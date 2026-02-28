package tripease.example.TripEase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tripease.example.TripEase.dtos.requests.BookingReqdtos;
import tripease.example.TripEase.dtos.responses.BookingResdtos;
import tripease.example.TripEase.services.BookingServices;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    @Autowired
    BookingServices bookingServices;

     @PostMapping("/book/customer/{id}")
    public BookingResdtos bookCab(@RequestBody BookingReqdtos bookingReqdtos, @PathVariable("id") int id){
         return bookingServices.bookCab(bookingReqdtos,id);
     }
}
