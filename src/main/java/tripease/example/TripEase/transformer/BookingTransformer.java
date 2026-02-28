package tripease.example.TripEase.transformer;

import tripease.example.TripEase.Enum.Status;
import tripease.example.TripEase.dtos.requests.BookingReqdtos;
import tripease.example.TripEase.dtos.responses.BookingResdtos;
import tripease.example.TripEase.entity.Booking;
import tripease.example.TripEase.entity.Cab;
import tripease.example.TripEase.entity.Customer;
import tripease.example.TripEase.entity.Driver;

public class BookingTransformer {
    public static Booking bookingReqdtosToBooking(BookingReqdtos bookingReqdtos, double perkmrate){
        return Booking.builder()
                .pickup(bookingReqdtos.getPickup())
                .destination(bookingReqdtos.getDestination())
                .tripdistence(bookingReqdtos.getTripdistence())
                .tripstatus(Status.RUNNING)
                .billamount(perkmrate*bookingReqdtos.getTripdistence()).build();
    }

    public static BookingResdtos bookingTobookingResdtos(Booking booking, Customer customer,
                                                         Cab cab, Driver driver){
        return BookingResdtos.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripdistence(booking.getTripdistence())
                .billamount(booking.getBillamount())
                .bookedAt(booking.getBookedAt())
                .lastupdateAt(booking.getLastupdateAt())
                .customerResdtos(CustomerTransformer.customertoCustomerResdtos(customer))
                .cabResdtos(CabTransformer.cabToCabResdtos(cab,driver))
                .build();
    }
}
